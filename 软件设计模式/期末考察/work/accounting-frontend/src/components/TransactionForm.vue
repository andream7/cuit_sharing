<!-- src/components/TransactionForm.vue -->
<template>
  <div>
    <el-form :model="form" label-width="80px">
      <el-form-item label="类型">
        <el-select v-model="form.type" placeholder="请选择">
          <el-option label="收入" value="INCOME"></el-option>
          <el-option label="支出" value="EXPENSE"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="金额">
        <el-input v-model.number="form.amount" type="number" placeholder="请输入金额"></el-input>
      </el-form-item>
      <el-form-item label="描述">
        <el-input v-model="form.description" placeholder="请输入描述"></el-input>
      </el-form-item>
      <el-form-item label="日期">
        <el-date-picker
            v-model="form.date"
            type="datetime"
            placeholder="选择日期和时间"
            style="width: 100%;">
        </el-date-picker>
      </el-form-item>
    </el-form>
    <div class="dialog-footer">
      <el-button size="small" @click="$emit('close')">取消</el-button>
      <el-button size="small" type="primary" @click="submitForm">确定</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'TransactionForm',
  props: {
    transaction: {
      type: Object,
      default: null
    }
  },
  data() {
    return {
      form: {
        id: null,
        type: '',
        amount: 0.0,
        description: '',
        date: new Date()
      }
    }
  },
  methods: {
    submitForm() {
      console.log('提交表单', this.form) // 调试用
      // 表单验证
      if (!this.form.type) {
        this.$message.error('类型不能为空')
        return
      }
      if (!this.form.amount || this.form.amount <= 0) {
        this.$message.error('金额必须大于0')
        return
      }
      if (!this.form.date) {
        this.$message.error('日期不能为空')
        return
      }
      // 触发提交事件
      this.$emit('submit', { ...this.form })
    }
  },
  created() {
    if (this.transaction) {
      this.form = { ...this.transaction }
      this.form.date = new Date(this.transaction.date)
    }
  }
}
</script>

<style scoped>
.dialog-footer {
  text-align: right;
  margin-top: 20px;
}
</style>
