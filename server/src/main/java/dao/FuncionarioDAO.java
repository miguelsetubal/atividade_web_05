package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Funcionario;

public class FuncionarioDAO {

	private static final Map<Integer, Funcionario> userMap = new HashMap<Integer, Funcionario>();
	private static int i = 1;



	public static Funcionario getUser(int id) {
		return userMap.get(id);
	}
	
		
	public static Funcionario addUser(String nome, String cargo, String dataNascimento, String dataEmpresa) {
		Funcionario func = new Funcionario(i, nome, cargo, dataNascimento, dataEmpresa);
		userMap.put(func.getId(), func);
		i++;
		return func;
	}

	public static Funcionario updateUser(int id, String nome, String cargo, String dataNascimento, String dataEmpresa) {
		Funcionario func = new Funcionario(id, nome, cargo, dataNascimento, dataEmpresa);
		userMap.put(func.getId(), func);
		return func;
	}

	public static void deleteUser(int id) {
		if (userMap.containsKey(id)) {
			userMap.remove(id);
		}
	}

	public static List<Funcionario> getAllUsers() {
		return new ArrayList<Funcionario>(userMap.values());
	}
	
	public static List<Funcionario> getFuncionarioByCargo(String cargo) {
        List<Funcionario> list = getAllUsers();
        List<Funcionario> funcionarios = new ArrayList<>();
        
        for (Funcionario func : list) {
            if (func.getCargo().equals(cargo)) {            
            	funcionarios.add(func);
            }
        }
        
        return funcionarios;
    }
	
	public static List<Funcionario> getFuncionarioByQtd(String qtd) {
        List<Funcionario> list = getAllUsers();
        List<Funcionario> funcionarios = new ArrayList<>();
        
        for(int i = 1; i <= Integer.parseInt(qtd); i++) {      	
              
            	  funcionarios.add(list.get(i-1));
            	 
              }       	
           
        
        
        return funcionarios;
    }
	
}