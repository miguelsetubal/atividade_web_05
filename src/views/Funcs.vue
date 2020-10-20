<template>
  <div>
    <button @click="$router.push({ name: 'UserInsert' })">Insert</button>

    <ul>
      <li v-for="func in funcs" :key="func.id">
        <div id="geral">
          <div class="left">
            <h4>Cod. Funcionário: {{ func.id }}</h4>
            <p>Nome: {{ func.nome }}</p>
            <p>Cargo: {{ func.cargo }}</p>
            <p>Data de Nascimento: {{ func.dnascimento }}</p>
            <p>Data de Entrada na Empresa: {{ func.dempresa }}</p>
          </div>
          <div class="right">
            <button
              @click="
                $router.push({ name: 'UserEdit', params: { id: func.id } })
              "
            >
              Update
            </button>
            <button @click="deleteUserById(func.id)">Delete</button>
          </div>
        </div>
        <hr />
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "Users",
  data() {
    return {
     funcs: [],
      baseURI: "http://localhost:8080/api/funcs",
    };
  },
  created: function() {
    this.getAll();
  },
  methods: {
    getAll: function() {
      this.$http.get(this.baseURI).then((result) => {
        this.funcs = result.data;
      });
    },
    deleteUserById: function(id) {
      this.$http.delete(this.baseURI + "/" + id).then((result) => {
        this.getAll();
      });
    },
  },
};
</script>

<style>
#geral {
  margin: 0;
}
.left {
  float: left;
  width: 75%;
}
.right {
  float: left;
  width: 25%;
}

hr {
  width: 100%;
}
</style>
