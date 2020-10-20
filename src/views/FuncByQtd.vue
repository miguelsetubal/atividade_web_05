<template>
  <div>
    Quantidade: <input type="number" name="" id="" v-model="qtd" /><br /><br />

    <button @click="fetchUserByQtd">Buscar</button><br /><br />

    <ul>
      <li v-for="func in func" :key="func.id">
       <h4>{{ func.id }}</h4>
            <h4>Cod. Funcionário: {{ func.id }}</h4>
            <p>Nome: {{ func.nome }}</p>
            <p>Cargo: {{ func.cargo }}</p>
            <p>Data de Nascimento: {{ func.dnascimento }}</p>
            <p>Data de Entrada na Empresa: {{ func.dempresa }}</p>
        <hr />
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "FuncByQtd",

  data() {
    return {
      id: 0,
      nome: "",
      cargo: "",
      dnascimento: "",
      dempresa: "",
      func: [],
      baseURI: "http://localhost:8080/api/funcs"
    };
  },
  methods: {
    fetchUserByQtd: function() {
      this.$http
        .get(this.baseURI + "/search2?qtd=" + this.qtd)
        .then(result => {
          this.func = result.data;
        })
        .catch(function(error) {
          console.log(error);
        });
        
        
    }
  }
};
</script>

<style></style>
