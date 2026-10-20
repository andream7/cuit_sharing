<!-- src/components/TransactionList.vue -->
<template>
  <div>
    <el-button type="primary" @click="openAddForm">添加事务</el-button>
    <el-table :data="transactions" style="width: 100%" stripe>
      <el-table-column prop="id" label="ID" width="50"></el-table-column>
      <el-table-column prop="type" label="类型"></el-table-column>
      <el-table-column prop="amount" label="金额"></el-table-column>
      <el-table-column prop="description" label="描述"></el-table-column>
      <el-table-column prop="date" label="日期" width="180">
        <template #default="scope">
          {{ formatDate(scope.row.date) }}
        </template>
      </el-table-column>
      <el-table-column label="操作" width="180">
        <template #default="scope">
          <el-button size="small" @click="openEditForm(scope.row)">编辑</el-button>
          <el-button size="small" type="danger" @click="deleteTransaction(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 事务表单弹窗 -->
    <el-dialog :title="dialogTitle" v-model="dialogVisible">
      <p>测试对话框内容</p>
      <TransactionForm
          :transaction="currentTransaction"
          @submit="handleFormSubmit"
          @close="dialogVisible = false"
      ></TransactionForm>
    </el-dialog>
  </div>
</template>

<script>
import TransactionService from '../services/TransactionService'
import TransactionForm from './TransactionForm.vue'

export default {
  name: 'TransactionList',
  components: {
    TransactionForm
  },
  data() {
    return {
      transactions: [],
      dialogVisible: false,
      dialogTitle: '',
      currentTransaction: null
    }
  },
  methods: {
    fetchTransactions() {
      TransactionService.getAllTransactions()
          .then(response => {
            this.transactions = response.data
          })
          .catch(error => {
            console.error(error)
            this.$message.error('获取事务失败')
          })
    },
    openAddForm() {
      console.log('打开添加事务表单') // 调试用
      this.dialogTitle = '添加事务'
      this.currentTransaction = null
      this.dialogVisible = true
    },
    openEditForm(transaction) {
      console.log('打开编辑事务表单', transaction) // 调试用
      this.dialogTitle = '编辑事务'
      this.currentTransaction = { ...transaction }
      this.dialogVisible = true
    },
    handleFormSubmit(transaction) {
      if (transaction.id) {
        // 编辑事务
        TransactionService.updateTransaction(transaction.id, transaction)
            .then(() => {
              this.$message.success('事务更新成功')
              this.fetchTransactions()
              this.dialogVisible = false
            })
            .catch(error => {
              console.error(error)
              this.$message.error('事务更新失败')
            })
      } else {
        // 添加事务
        TransactionService.createTransaction(transaction)
            .then(() => {
              this.$message.success('事务添加成功')
              this.fetchTransactions()
              this.dialogVisible = false
            })
            .catch(error => {
              console.error(error)
              this.$message.error('事务添加失败')
            })
      }
    },
    deleteTransaction(id) {
      this.$confirm('确定要删除此事务吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        TransactionService.deleteTransaction(id)
            .then(() => {
              this.$message.success('事务删除成功')
              this.fetchTransactions()
            })
            .catch(error => {
              console.error(error)
              this.$message.error('事务删除失败')
            })
      }).catch(() => {
        // 取消删除
      })
    },
    formatDate(dateStr) {
      const date = new Date(dateStr)
      return date.toLocaleString()
    }
  },
  created() {
    this.fetchTransactions()
  }
}
</script>

<style scoped>
</style>
