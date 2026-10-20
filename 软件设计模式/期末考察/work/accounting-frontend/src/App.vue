<!-- src/App.vue -->
<template>
  <div id="app">
    <el-container>
      <el-header>
        <h2>电子记账系统</h2>
      </el-header>
      <el-main>
        <transaction-list></transaction-list>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import TransactionList from './components/TransactionList.vue';

export default {
  name: 'App',
  components: {
    TransactionList
  }
};
</script>

<style>
#app {
  margin: 20px;
}
</style>
