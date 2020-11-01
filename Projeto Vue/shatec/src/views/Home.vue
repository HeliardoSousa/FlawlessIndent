<template>
  <div class="home">
      <ListProdutos></ListProdutos>
  </div>
</template>

<script>
import ListProdutos from "../components/ListProdutos.vue"
export default {
  name: 'Home',
  components: {
      ListProdutos
  }
}
</script>

<style scoped>
</style>