package ControllerCl;

import ClienteConexao.ClienteB;
import ModeloC.Cliente;

public class ClienteController implements IControllerCL {

	private Cliente cliente;
	

	public void executa(Object view, int parameter) {
		ClienteB clienteB = new ClienteB();
		
		cliente=(Cliente) view;
		
		if(parameter == 1) {
			clienteB.Salvar(cliente);
		}
		if(parameter==2) {
			clienteB.Atualizar(cliente);
		}
		
		if(parameter == 3) {
			clienteB.apagar(cliente.getId());
		}
		if(parameter == 4) {
			clienteB.ListarTd();
		}		
	}
}