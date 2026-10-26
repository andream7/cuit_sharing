// 五子棋 - JavaScript 实现 - 两人对战 https://juejin.cn/post/7158618625400651806
// 五子棋 - JavaScript 实现 -人机交互 https://juejin.cn/post/7168730056414461966
// 五子棋枚举值
const EnumRoles = {
  EMPTY: 0, // 该点没有子
  BLACK: 1, // 黑子，人机交互的时候，为机器执子
  WHITE: -1, // 白子
};

const PLayerWinState = {
  win: "你赢了",
  fail: "你输了",
};

// 设置不同的棋局
// 黑子的棋局
// 连五
let wins = [[1, 1, 1, 1, 1]];
// 活四
let unCovered4 = [[0, 1, 1, 1, 1, 0]];
// 活三：包含连活三和跳活三
let unCovered3 = [
  [0, 1, 1, 1, 0, 0],
  [0, 0, 1, 1, 1, 0],
  [0, 1, 0, 1, 1, 0],
  [0, 1, 1, 0, 1, 0],
];
// 活二，类似活三
let unCovered2 = [
  [0, 0, 1, 1, 0, 0],
  [0, 1, 0, 1, 0, 0],
  [0, 0, 1, 0, 1, 0],
  [0, 1, 1, 0, 0, 0],
  [0, 0, 0, 1, 1, 0],
  [0, 1, 0, 0, 1, 0],
];
// 冲四：包含跳冲和连冲
let covered4 = [
  [-1, 1, 0, 1, 1, 1],
  [-1, 1, 1, 0, 1, 1],
  [-1, 1, 1, 1, 0, 1],
  [-1, 1, 1, 1, 1, 0],
  [0, 1, 1, 1, 1, -1],
  [1, 0, 1, 1, 1, -1],
  [1, 1, 0, 1, 1, -1],
  [1, 1, 1, 0, 1, -1],
];
// 眠三，类似冲四
let covered3 = [
  [-1, 1, 1, 1, 0, 0],
  [-1, 1, 1, 0, 1, 0],
  [-1, 1, 0, 1, 1, 0],
  [0, 0, 1, 1, 1, -1],
  [0, 1, 0, 1, 1, -1],
  [0, 1, 1, 0, 1, -1],
  [-1, 1, 0, 1, 0, 1, -1],
  [-1, 0, 1, 1, 1, 0, -1],
  [-1, 1, 1, 0, 0, 1, -1],
  [-1, 1, 0, 0, 1, 1, -1],
];
// 黑子的所有情况
let allCombos = [wins, unCovered4, unCovered3, unCovered2, covered4, covered3];
// 白子同理
for (let k = 0; k < allCombos.length; k++) {
  let temp = [];
  for (let j = 0; j < allCombos[k].length; j++) {
    let tmp = [];
    for (let i = 0; i < allCombos[k][j].length; i++) {
      tmp[i] = -allCombos[k][j][i];
    }
    temp.push(tmp);
  }
  for (let m = 0; m < temp.length; m++) {
    allCombos[k].push(temp[m]);
  }
}
// 上面 allCombos 所有黑白子的组合

// 棋局已经出现胜者分数
const WIN_VALUE = 1000000000;

// 预设不同的组合对应的得分

let valueCombo = function (w, u2, u3, u4, c3, c4) {
  if (w > 0) return WIN_VALUE;
  if (u4 > 0) return 100000000;
  if (c4 > 1) return 10000000;
  if (u3 > 0 && c4 > 0) return 1000000; // 活三与眠四并存，获胜概率更高
  if (u3 > 1) return 100000;

  if (u3 == 1) {
    if (u2 == 3) return 40000;
    if (u2 == 2) return 38000;
    if (u2 == 1) return 35000;
    return 3450;
  }

  if (c4 == 1) {
    if (u2 == 3) return 4500;
    if (u2 == 2) return 4200;
    if (u2 == 1) return 4100;
    return 4050;
  }

  if (c3 == 1) {
    if (u2 == 3) return 3400;
    if (u2 == 2) return 3300;
    if (u2 == 1) return 3100;
  }

  if (c3 == 2) {
    if (u2 == 2) return 3000;
    if (u2 == 1) return 2900;
  }

  if (c3 == 3) {
    if (u2 == 1) return 2800;
  }

  if (u2 == 4) return 2700;
  if (u2 == 3) return 2500;
  if (u2 == 2) return 2000;
  if (u2 == 1) return 1000;
  return 0;
};

// 查找数据，要找的数组是否存在设定的数组中
// 源数组 arr 中查找是否存在与给定数组 inArr 相同的子数组
let findArray = function (arr, inArr) {
  // 需要查找的数组的长度
  let fCount = arr.length;
  // 源数组长度，比如黑子五连 [1, 1, 1, 1, 1]
  let sCount = inArr.length;
  let k;
  for (let i = 0; i <= fCount - sCount; i++) {
    k = 0;
    for (let j = 0; j < sCount; j++) {
      if (arr[i + j] == inArr[j]) k++;
      else break;
    }
    if (k == sCount) return true;
  }
  return false;
};
// 函数 isAnyInArrays(combos, arr) 的作用是判断 arr 是否包含了给定数组 combos 中的任意一个子数组
let isAnyInArrays = function (combos, arr) {
  for (let i = 0; i < combos.length; i++) {
    if (findArray(arr, combos[i])) return true;
  }
  return false;
};

// 当前位置的组合情况
let initCombinations = {};
initCombinations.winValue = WIN_VALUE;
// 组合的值，考虑四个方向，放回的是四个方向获取的分数值
initCombinations.valuePosition = function (arr1, arr2, arr3, arr4) {
  let w = 0,
    u2 = 0,
    u3 = 0,
    u4 = 0,
    c3 = 0,
    c4 = 0;
  let allArr = [arr1, arr2, arr3, arr4];
  for (let i = 0; i < allArr.length; i++) {
    if (isAnyInArrays(wins, allArr[i])) {
      w++;
      continue;
    }
    if (isAnyInArrays(covered4, allArr[i])) {
      c4++;
      continue;
    }
    if (isAnyInArrays(covered3, allArr[i])) {
      c3++;
      continue;
    }
    if (isAnyInArrays(unCovered4, allArr[i])) {
      u4++;
      continue;
    }
    if (isAnyInArrays(unCovered3, allArr[i])) {
      u3++;
      continue;
    }
    if (isAnyInArrays(unCovered2, allArr[i])) {
      u2++;
    }
  }
  return valueCombo(w, u2, u3, u4, c3, c4);
};

/*
 * 生成矩阵
 * 15 * 15 的大小
 */
Array.matrix = function (m, n, initial) {
  let a,
    i,
    j,
    mat = [];
  for (i = 0; i < m; i++) {
    a = [];
    for (j = 0; j < n; j++) {
      a[j] = initial;
    }
    mat[i] = a;
  }
  return mat;
};

let gameSize = 5; // 五子连线
let ring = 1; // 当前子周围的环情况
let win = false; // 游戏是否决出胜负
let cellsCount = 15; // 单元格的数量
let curState = Array.matrix(15, 15, 0); // 当前的矩阵状态，初始化全部为 0 ，没有子
let maxPlayer = -1;
let combinations = initCombinations; // 初始化当前位置的情况
if (maxPlayer === -1) curState[7][7] = 1; // 初始化黑子于矩阵，默认下在天元位置

// 检查输赢，四个方向进行判断

let checkWin = function () {
  for (let i = 0; i < cellsCount; i++) {
    for (let j = 0; j < cellsCount; j++) {
      if (curState[i][j] == 0) continue;
      let playerVal = combinations.valuePosition(
        // 水平
        getCombo(curState, curState[i][j], i, j, 1, 0),
        // 竖直
        getCombo(curState, curState[i][j], i, j, 0, 1),
        // 正斜线
        getCombo(curState, curState[i][j], i, j, 1, 1),
        // 反斜线
        getCombo(curState, curState[i][j], i, j, 1, -1)
      );
      if (playerVal === combinations.winValue) {
        win = true;
      }
    }
  }
};

// 极大极小值算法，在博弈树中进行深度优先搜索
let miniMax = function minimax(node, depth, player, parent) {
  if (depth == 0) return heuristic(node, parent);
};
// heuristic计算当前节点的启发式评估值
// 去重，博弈树中可能有很多位置是等效的，通过去重节约资源和时间
let isAllSatisfy = function (candidates, pointX, pointY) {
  let counter = 0;
  for (let i = 0; i < candidates.length; i++) {
    if (pointX != candidates[i][0] || pointY != candidates[i][1]) counter++;
  }
  return counter == candidates.length;
};
/*
* 首先找到当前游戏状态中已经有棋子的位置，然后检查它们周围的邻域位置是否为空
如果是，则将这些邻域位置作为候选位置，并生成对应的子状态
最后，返回包含所有子状态的数组。
*/
let getChilds = function (parent, player) {
  let children = []; //用于存储子状态
  let candidates = []; //用于存储可能的子状态候选者
  for (let i = 0; i < cellsCount; i++) {
    for (let j = 0; j < cellsCount; j++) {
      if (parent[i][j] != 0) {
        for (let k = i - ring; k <= i + ring; k++) {
          for (let l = j - ring; l <= j + ring; l++) {
            if (k >= 0 && l >= 0 && k < cellsCount && l < cellsCount) {
              if (parent[k][l] == 0) {
                let curPoint = [k, l]; // 当前可下点
                let flag = isAllSatisfy(candidates, curPoint[0], curPoint[1]);
                // 查找符合条件的候选者
                if (flag) candidates.push(curPoint);
              }
            }
          }
        }
      }
    }
  }
  for (let f = 0; f < candidates.length; f++) {
    // 复制一份矩阵
    let tmp = Array.matrix(cellsCount, cellsCount, 0); //Array.matrix = function(m, n, initial)
    for (let m = 0; m < cellsCount; m++) {
      for (let n = 0; n < cellsCount; n++) {
        tmp[m][n] = parent[m][n]; // 将当前矩阵的状态同步到临时矩阵中
      }
    }
    // 模拟落子情况
    tmp[candidates[f][0]][candidates[f][1]] = -player;
    children.push(tmp);
  }
  return children;
};

/*
 *  获取当前的组合
 *  棋盘节点情况
 *  curPlayer 当前玩家
 *  i 棋盘横轴遍历
 *  y 棋盘横轴遍历
 *  dx 棋盘横轴偏移位置
 *  dy 棋盘纵轴偏移位置
 *  combo 返回当前方向的当前玩家的节点情况，比如 [0, 0, 0, 0, -1, 0, 0, 0, 0]。combo.length 最长为 9 = 2 * gameSize - 1
 */
// getCombo 函数，用于获取游戏中特定位置的连续组合序列
let getCombo = function (node, curPlayer, i, j, dx, dy) {
  let combo = [curPlayer];
  for (let m = 1; m < gameSize; m++) {
    let nextX1 = i - dx * m;
    let nextY1 = j - dy * m;
    if (
      nextX1 >= cellsCount ||
      nextY1 >= cellsCount ||
      nextX1 < 0 ||
      nextY1 < 0
    )
      break;
    let next1 = node[nextX1][nextY1];
    // 如果 nextX1 和 nextY1 超出了棋盘边界，
    // 或者对应位置的值为当前玩家的相反值 -curPlayer，则跳出循环
    if (node[nextX1][nextY1] == -curPlayer) {
      combo.unshift(next1);
      break;
    }
    combo.unshift(next1);
  }
  for (let k = 1; k < gameSize; k++) {
    let nextX = i + dx * k;
    let nextY = j + dy * k;
    if (nextX >= cellsCount || nextY >= cellsCount || nextX < 0 || nextY < 0)
      break;
    let next = node[nextX][nextY];
    if (next == -curPlayer) {
      combo.push(next);
      break;
    }
    combo.push(next);
  }
  return combo;
};

/*
 * 思考最优解
 * @param { array[][] } newNode 新的棋局
 * @param { array[][] } oldNode 旧的棋局 ｜ 当前棋局
 */
let heuristic = function (newNode, oldNode) {
  for (let i = 0; i < cellsCount; i++) {
    for (let j = 0; j < cellsCount; j++) {
      if (newNode[i][j] != oldNode[i][j]) {
        let curCell = newNode[i][j];
        // 获取对手在相同的连子方向上的价值评估
        let playerVal = combinations.valuePosition(
          getCombo(newNode, curCell, i, j, 1, 0),
          getCombo(newNode, curCell, i, j, 0, 1),
          getCombo(newNode, curCell, i, j, 1, 1),
          getCombo(newNode, curCell, i, j, 1, -1)
        );
        // 取反，对手分数
        newNode[i][j] = -curCell;
        let oppositeVal = combinations.valuePosition(
          getCombo(newNode, -curCell, i, j, 1, 0),
          getCombo(newNode, -curCell, i, j, 0, 1),
          getCombo(newNode, -curCell, i, j, 1, 1),
          getCombo(newNode, -curCell, i, j, 1, -1)
        );
        // 还原
        newNode[i][j] = -curCell;
        // 这里乘以一个二是为了加大其权重，使算法更加偏向于进攻，增加胜利的机会
        // 这里可以对系数进行优化
        return 2 * playerVal + oppositeVal;
      }
    }
  }
  return 0;
};

// 计算获取逻辑，获取最佳的机器下棋的位置
let getLogic = {}; //winState方法和makeAnswer方法
getLogic.winState = "";
/*
 * 获取最优的落子
 * param { number } x 白子落点 x 轴
 * param { number } y 白子落点 y 轴
 * return { array[] } 返回最优落子位置
 */
getLogic.makeAnswer = function (x, y) {
  let that = this;
  // 更改当前举证的状态
  curState[x][y] = maxPlayer;
  // 对玩家检查输赢
  checkWin();
  if (win) {
    that.winState = PLayerWinState.win;
    return;
  }
  let answ = [-1, -1]; // 预设的最佳位置，在棋盘外，这个随便
  // 获取候选值
  let c = getChilds(curState, maxPlayer);
  let maxChild = -1;
  let maxValue = Number.MIN_VALUE; // 最小的正值
  for (let k = 0; k < c.length; k++) {
    // 计算当前的得分值
    let curValue = miniMax(c[k], 0, -maxPlayer, curState);
    if (maxValue < curValue) {
      maxValue = curValue;
      maxChild = k; // 获取最大值的索引
    }
  }
  for (let i = 0; i < cellsCount; i++) {
    for (let j = 0; j < cellsCount; j++) {
      if (c[maxChild][i][j] != curState[i][j]) {
        answ[0] = i;
        answ[1] = j;
        curState[answ[0]][answ[1]] = -maxPlayer;
        checkWin();
        // 判断计算机的输赢
        if (win) {
          that.winState = PLayerWinState.fail;
        }
        return answ;
      }
    }
  }
  return answ;
};

let logic = getLogic;
let gameOver = false;

// 类 构造函数，用于创造一个五子棋游戏
class GobangPerson2Person {
  constructor(options) {
    // 相关选项，可以通过实例化进行修改
    this.options = options;
    // 获取棋盘元素
    this.checkerboardDom = document.getElementById("checkerboard");
    // 棋盘矩阵
    this.checkerboardMatrix = [];
    // 获取当前棋子元素
    this.currentRoleDom = document.getElementById("current-role");
    // 获取游戏结果的元素
    this.resultMsgDom = document.getElementById("result-msg");
    // 信息结果
    this.message = "游戏中";
    // 单元格信息
    this.lattice = {
      width: 30,
      height: 30,
    };
    // 初始化
    this.init();
  }

  init() {
    const { options } = this;
    this.role = options.role || EnumRoles.BLACK;
    this.win = false;
    // 设置当前轮到哪个执棋
    this.setCurrentRole();
    // 设置结果信息提示
    this.setResultMsgHint();
    // 绘制棋盘
    this.drawCheckerboard();
    // 初始化棋盘矩阵
    this.initCheckerboardMatrix();
    // 监听落子
    this.listenDownChessman();
  }
  // 设置执棋角色
  setCurrentRole() {
    if (Object.is(this.role, EnumRoles.BLACK)) {
      this.currentRoleDom.setAttribute("class", "chessman black");
      this.resultMsgDom.setAttribute("class", "black");
    } else {
      this.currentRoleDom.setAttribute("class", "chessman white");
      this.resultMsgDom.setAttribute("class", "white");
    }
  }
  // 游戏结果的innerHTML
  setResultMsgHint() {
    this.resultMsgDom.innerHTML = this.message;
  }

  drawCheckerboard() {
    // 解构赋值语法  将 this.options 的值赋给 options 变量
    const { options, lattice } = this;
    const { count, borderColor } = options.gobangStyle; //15 #bfbfbf
    this.checkerboardDom.width = lattice.width * count;
    this.checkerboardDom.height = lattice.height * count;
    // 进行2D绘图操作
    const context = this.checkerboardDom.getContext("2d");
    context.strokeStyle = borderColor; // 画笔的颜色
    context.lineWidth = 2; // 画笔的粗细
    // 开画
    for (let i = 0; i < count; i += 1) {
      context.moveTo(15 + i * lattice.width, 15);
      context.lineTo(15 + i * lattice.width, count * lattice.height - 15);
      context.stroke(); // 画竖线
      context.moveTo(15, 15 + i * lattice.height);
      context.lineTo(count * lattice.height - 15, 15 + i * lattice.width);
      context.stroke(); // 画横线
    }
  }
  //   初始化棋盘矩阵
  initCheckerboardMatrix() {
    const { count } = this.options.gobangStyle; //15
    const _checkerboardMatrix = []; //空数组，存放棋盘矩阵
    for (let x = 0; x < count; x += 1) {
      _checkerboardMatrix[x] = [];
      for (let y = 0; y < count; y += 1) {
        _checkerboardMatrix[x][y] = 0; // 0 表示空
      }
    }
    this.checkerboardMatrix = _checkerboardMatrix; // 可以通过 console.table 查看矩阵的结构和对应的值
  }
  // 监听棋盘上的点击事件
  listenDownChessman() {
    // 给棋盘元素绑定点击事件的回调函数，提取event对象中的属性，并赋值给x，y对象
    this.checkerboardDom.onclick = (event) => {
      let { offsetX: x, offsetY: y } = event;
      // 30 30
      const { width, height } = this.lattice;
      // 计算点击事件发生的格子位置，通过Math.round方法将结果四舍五入，得到最接近的整数
      x = Math.round((x - 15) / width);
      y = Math.round((y - 15) / height);
      if (
        this.checkerboardMatrix[x][y] !== undefined &&
        Object.is(this.checkerboardMatrix[x][y], 0)
      ) {
        this.checkerboardMatrix[x][y] = this.role;
        // 刻画棋子
        this.drawChessman({ x, y }, Object.is(this.role, EnumRoles.BLACK));
        // 切换对战角色
        this.role = Object.is(this.role, EnumRoles.BLACK)
          ? EnumRoles.WHITE
          : EnumRoles.BLACK;
        // 设置当前执棋
        if (!this.win) {
          // 游戏中
          this.setCurrentRole();
        } else {
          // 游戏结束
          Object.is(this.role, EnumRoles.BLACK)
            ? this.currentRoleDom.setAttribute("class", "chessman win-white")
            : this.currentRoleDom.setAttribute("class", "chessman win-black");
          this.message = "赢得本场胜利";
          this.setResultMsgHint();
        }
      }
    };
  }
  //   绘制棋子
  drawChessman(coordinate, isBlack) {
    const { x, y } = coordinate;
    const { width, height } = this.lattice;
    const context = this.checkerboardDom.getContext("2d");
    context.beginPath(); //开始绘制
    context.arc(15 + x * width, 15 + y * height, 13, 0, 2 * Math.PI); // 绘制半径为 13 的圆
    context.closePath();
    //渐变
    let gradient = context.createRadialGradient(
      15 + x * width + 2,
      15 + y * height - 2,
      13,
      15 + x * width + 2,
      15 + y * height - 2,
      0
    );
    if (isBlack) {
      // 黑子
      gradient.addColorStop(0, "#0a0a0a");
      gradient.addColorStop(1, "#636766");
    } else {
      // 白子
      gradient.addColorStop(0, "#d1d1d1");
      gradient.addColorStop(1, "#f9f9f9");
    }
    context.fillStyle = gradient;
    context.fill();
    this.gameReferee(coordinate, isBlack ? EnumRoles.BLACK : EnumRoles.WHITE);
  }

  /*
   * @method gameReferee 判断输赢
   * @param coordinate 坐标 (x, y)
   * @paran role 角色
   */
  gameReferee(coordinate, role) {
    const { x, y } = coordinate; //棋子坐标位置
    if (x === undefined || y === undefined || role === undefined) return;
    // 连子次数
    let countContinuous = 0;
    // x 轴的情况
    let XContinuous = this.checkerboardMatrix.map((x) => x[y]);
    // y 轴的情况
    let YContinuous = this.checkerboardMatrix[x];
    let S1Continuous = [];
    let S2Continuous = [];
    this.checkerboardMatrix.forEach((_x, i) => {
      // 左斜线
      const S1Item = _x[y - (x - i)];
      if (S1Item !== undefined) {
        S1Continuous.push(S1Item);
      }
      // 右斜线
      const S2Item = _x[y + (x - i)];
      if (S2Item !== undefined) {
        S2Continuous.push(S2Item);
      }
    });
    // console.log('XContinuous', XContinuous);
    // console.log('YContinuous', YContinuous);
    // console.log('S1Continuous', S1Continuous);
    // console.log('S2Continuous', S2Continuous);
    // 当前落棋点所在的X轴/Y轴/交叉斜轴，只要有能连起来的5个子的角色即有胜者
    [XContinuous, YContinuous, S1Continuous, S2Continuous].forEach((axis) => {
      if (
        axis.some(
          (x, i) =>
            axis[i] !== 0 &&
            axis[i - 2] === axis[i - 1] &&
            axis[i - 1] === axis[i] &&
            axis[i] === axis[i + 1] &&
            axis[i + 1] === axis[i + 2]
        )
      ) {
        countContinuous++;
      }
    });

    if (countContinuous) {
      this.win = true;
      this.checkerboardDom.onclick = null; // 游戏结束，不允许点击
    }
  }
}

// 类
class GobangMachine2Person {
  constructor(options) {
    // 相关选项，可以通过实例化进行修改
    this.options = options;
    // 获取棋盘元素
    this.checkerboardDom = document.getElementById("checkerboard");
    // 获取当前棋子元素
    this.currentRoleDom = document.getElementById("current-role");
    // 获取游戏结果的元素
    this.resultMsgDom = document.getElementById("result-msg");
    // 信息结果
    this.message = "游戏中";
    // 单元格信息
    this.lattice = {
      width: 30,
      height: 30,
    };
    // 初始化
    this.init();
  }

  init() {
    const { options } = this;
    this.role = options.role || EnumRoles.BLACK;

    // 绘制棋盘
    this.drawCheckerboard();

    // 监听点击棋盘落子
    this.listenDownChessman();
  }
  // 当前下棋的角色
  setCurrentRole() {
    if (Object.is(this.role, EnumRoles.BLACK)) {
      this.currentRoleDom.setAttribute("class", "chessman black");
      this.resultMsgDom.setAttribute("class", "black");
    } else {
      this.currentRoleDom.setAttribute("class", "chessman white");
      this.resultMsgDom.setAttribute("class", "white");
    }
  }
  // 当前信息
  setResultMsgHint() {
    this.resultMsgDom.innerHTML = this.message;
  }
  // 画棋盘
  drawCheckerboard() {
    const { options, lattice } = this;
    const { count, borderColor } = options.gobangStyle;
    this.checkerboardDom.width = lattice.width * count;
    this.checkerboardDom.height = lattice.height * count;

    const context = this.checkerboardDom.getContext("2d"); // 获取画笔
    context.strokeStyle = borderColor; // 画笔的颜色
    context.lineWidth = 2; // 画笔的粗细

    for (let i = 0; i < count; i += 1) {
      context.moveTo(15 + i * lattice.width, 15);
      context.lineTo(15 + i * lattice.width, count * lattice.height - 15);
      context.stroke(); // 画竖线
      context.moveTo(15, 15 + i * lattice.height);
      context.lineTo(count * lattice.height - 15, 15 + i * lattice.width);
      context.stroke(); // 画横线
    }
  }
  // 绘制棋子
  drawChessman(coordinate, isBlack) {
    const { x, y } = coordinate;
    const { width, height } = this.lattice;
    const context = this.checkerboardDom.getContext("2d");
    context.beginPath();
    context.arc(15 + x * width, 15 + y * height, 13, 0, 2 * Math.PI); // 绘制半径为 13 的圆
    context.closePath();
    //渐变
    let gradient = context.createRadialGradient(
      15 + x * width + 2,
      15 + y * height - 2,
      13,
      15 + x * width + 2,
      15 + y * height - 2,
      0
    );
    if (isBlack) {
      // 黑子
      gradient.addColorStop(0, "#0a0a0a");
      gradient.addColorStop(1, "#636766");
    } else {
      // 白子
      gradient.addColorStop(0, "#d1d1d1");
      gradient.addColorStop(1, "#f9f9f9");
    }
    context.fillStyle = gradient;
    context.fill();
  }
  // 监听落子
  listenDownChessman() {
    this.checkerboardDom.onclick = (event) => {
      let { offsetX: x, offsetY: y } = event;
      const { width, height } = this.lattice;
      x = Math.round((x - 15) / width);
      y = Math.round((y - 15) / height);

      if (
        curState[x][y] === EnumRoles.BLACK ||
        curState[x][y] === EnumRoles.WHITE
      )
        return;

      // 白子落子
      this.drawChessman(
        {
          x,
          y,
        },
        false
      );

      // 基于白子的落子位置，算出机器的落子位置
      let answer = logic.makeAnswer(x, y);

      if (logic.winState === PLayerWinState.win) {
        gameOver = true;
        this.message = "赢得本场胜利";
        this.currentRoleDom.setAttribute("class", "chessman win-white");
        this.setResultMsgHint();
        this.checkerboardDom.onclick = null; // 游戏结束，不允许点击
        return;
      }

      this.role = EnumRoles.BLACK;
      this.setCurrentRole();

      // 绘制黑子
      this.drawChessman(
        {
          x: answer[0],
          y: answer[1],
        },
        true
      );

      // 是否结束
      if (logic.winState === PLayerWinState.fail) {
        gameOver = true;
        this.message = "赢得本场胜利";
        this.currentRoleDom.setAttribute("class", "chessman win-black");
        this.setResultMsgHint();
        this.checkerboardDom.onclick = null; // 游戏结束，不允许点击
      } else {
        this.role = EnumRoles.WHITE;
        this.setCurrentRole();
      }
    };
  }
}
// 游戏开始的点击事件
(function () {
  // 按钮确认元素
  let confirmBeginDom = document.getElementById("confirm-begin");
  // 游戏模式元素
  let modeDom = document.getElementById("mode");
  // 参数初始化板块元素
  let parameterInitDom = document.getElementById("parameter-init");
  // 人和人玩游戏板块元素
  let person2personDom = document.getElementById("person2person");

  confirmBeginDom.addEventListener("click", function () {
    let modeVal = modeDom.options[modeDom.selectedIndex].value;
    parameterInitDom.setAttribute("class", "inactive");
    person2personDom.setAttribute("class", "active");

    // 跟朋友玩
    if (modeVal === "person2person") {
      // 实例化
      new GobangPerson2Person({
        role: EnumRoles.BLACK,
        gobangStyle: {
          count: 15,
          borderColor: "#bfbfbf",
        },
      });
    }
    if (modeVal === "machine2person") {
      // 实例化
      let gobangMachine2Person = new GobangMachine2Person({
        role: EnumRoles.WHITE,
        gobangStyle: {
          count: cellsCount,
          borderColor: "#bfbfbf",
        },
      });
      // 落子于天元的位置
      gobangMachine2Person.drawChessman({ x: 7, y: 7 }, true);
      // 设置当前角色
      gobangMachine2Person.setCurrentRole();
      // 设置提示信息
      gobangMachine2Person.setResultMsgHint();
    }
  });
})();
