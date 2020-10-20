package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.FuncionarioDAO;
import model.Funcionario;

@WebServlet("/api/funcs/*")
public class FuncionarioService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FuncionarioService() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// GET BY ID
		String pathInfo = request.getPathInfo();

		if (pathInfo != null) {
			String[] params = pathInfo.split("/");

			if (params.length > 0) {
				Funcionario user = FuncionarioDAO.getUser(Integer.parseInt(params[1]));

				if (user != null) {
					JSONObject jsonObject = new JSONObject();

					jsonObject.put("id", user.getId());
					jsonObject.put("nome", user.getNome());
					jsonObject.put("cargo", user.getCargo());
					jsonObject.put("dataNascimento", user.getDataNascimento());
					jsonObject.put("dataEmpresa", user.getDataEmpresa());

					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().print(jsonObject.toString());
					response.getWriter().flush();
				}
				return;
			}
		}
		
		// GET BY CARGO
				if (request.getParameter("cargo") != null) {					
					List<Funcionario> funcs = FuncionarioDAO.getFuncionarioByCargo(request.getParameter("cargo"));
					try {
						JSONArray jArray = new JSONArray();

						for (Funcionario user : funcs) {
							JSONObject jsonObject = new JSONObject();

							jsonObject.put("id", user.getId());
							jsonObject.put("nome", user.getNome());
							jsonObject.put("cargo", user.getCargo());
							jsonObject.put("dataNascimento", user.getDataNascimento());
							jsonObject.put("dataEmpresa", user.getDataEmpresa());

							jArray.put(jsonObject);
						}

						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						response.getWriter().print(jArray.toString());
						response.getWriter().flush();
					} catch (Exception e) {

					}
					return;
				}
				
				// GET BY qtd
				if (request.getParameter("qtd") != null) {					
					List<Funcionario> funcs = FuncionarioDAO.getFuncionarioByQtd(request.getParameter("qtd"));
					try {
						JSONArray jArray = new JSONArray();

						for (Funcionario user : funcs) {
							JSONObject jsonObject = new JSONObject();

							jsonObject.put("id", user.getId());
							jsonObject.put("nome", user.getNome());
							jsonObject.put("cargo", user.getCargo());
							jsonObject.put("dataNascimento", user.getDataNascimento());
							jsonObject.put("dataEmpresa", user.getDataEmpresa());

							jArray.put(jsonObject);
						}

						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						response.getWriter().print(jArray.toString());
						response.getWriter().flush();
					} catch (Exception e) {

					}
					return;
				}
			

		// GET ALL
		List<Funcionario> list = FuncionarioDAO.getAllUsers();

		try {
			JSONArray jArray = new JSONArray();

			for (Funcionario user : list) {
				JSONObject jsonObject = new JSONObject();

				jsonObject.put("id", user.getId());
				jsonObject.put("nome", user.getNome());
				jsonObject.put("cargo", user.getCargo());
				jsonObject.put("dataNascimento", user.getDataNascimento());
				jsonObject.put("dataEmpresa", user.getDataEmpresa());

				jArray.put(jsonObject);
			}

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jArray.toString());
			response.getWriter().flush();
		} catch (Exception e) {

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
		}

		Funcionario user = null;
		JSONObject jsonObject = null;

		try {
			// Request
			jsonObject = new JSONObject(jb.toString());
			user = FuncionarioDAO.addUser(jsonObject.getString("nome"), jsonObject.getString("cargo"), jsonObject.getString("dataNascimento"), jsonObject.getString("dataEmpresa"));

			// Response
			jsonObject = new JSONObject();
			jsonObject.put("id", user.getId());
			jsonObject.put("nome", user.getNome());
			jsonObject.put("cargo", user.getCargo());
			jsonObject.put("dataNascimento", user.getDataNascimento());
			jsonObject.put("dataEmpresa", user.getDataEmpresa());

		} catch (JSONException e) {
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonObject.toString());
		response.getWriter().flush();
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// UPDATE BY ID
        String pathInfo = request.getPathInfo();
 
        if (pathInfo != null) {
            String[] params = pathInfo.split("/");
 
            if (params.length > 0) {
                StringBuffer jb = new StringBuffer();
                String line = null;
                try {
                    BufferedReader reader = request.getReader();
                    while ((line = reader.readLine()) != null)
                        jb.append(line);
                } catch (Exception e) {
                }
 
                Funcionario user = null;
                JSONObject jsonObject = null;
 
                try {
                    // Request
                    jsonObject = new JSONObject(jb.toString());
                    user = FuncionarioDAO.updateUser(Integer.parseInt(params[1]), jsonObject.getString("nome"), jsonObject.getString("cargo"), jsonObject.getString("dataNascimento"), jsonObject.getString("dataEmpresa"));
 
                    // Response
                    jsonObject = new JSONObject();
                    jsonObject.put("id", user.getId());
        			jsonObject.put("nome", user.getNome());
        			jsonObject.put("cargo", user.getCargo());
        			jsonObject.put("dataNascimento", user.getDataNascimento());
        			jsonObject.put("dataEmpresa", user.getDataEmpresa());
 
                } catch (JSONException e) {
                }
 
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print(jsonObject.toString());
                response.getWriter().flush();
            }
        }
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DELETE BY ID
        String pathInfo = request.getPathInfo();
 
        if (pathInfo != null) {
            String[] params = pathInfo.split("/");
 
            if (params.length > 0) {
                FuncionarioDAO.deleteUser(Integer.parseInt(params[1]));
 
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().flush();
            }
        }
	}

}
