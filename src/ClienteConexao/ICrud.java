package ClienteConexao;

import java.util.List;

public interface ICrud {
 
	public void Salvar(Object C);
	public void Atualizar(Object C);
	public void apagar(int Id);
	//public Object get(int Id);
	public List<Object>ListarTd();

	
	
}
