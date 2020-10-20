<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Lista Com Todos os Funcionarios</router-link>          
      <router-link to="/users"> | Funcionarios</router-link> 
      <router-link to="/users/id"> | Funcionarios ID</router-link>
       <router-link to="/cargo"> | Funcionarios Cargo</router-link>
        <router-link to="/qtd"> | Funcionarios Quantidade</router-link>
      
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  data() {
    return {
        
    };
  },
  mounted: function() {
    if (localStorage.getItem("funcs")) {
     
    }
  },
  methods: {
    logout: function() {
      localStorage.removeItem("func");
      location.reload();
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

ul {
  list-style-type: none;
  text-align: left;
  white-space: nowrap;  
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
