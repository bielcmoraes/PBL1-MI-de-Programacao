package controller;

import java.util.ArrayList;

import model.Fornecedor;
import model.FornecedorCopyable;
import view.FornecedorView;

/**Classe responsável por implementar os metódos de cadastrar, editar e excluir fornecedor que foram especificados na classe FornecedorCopyable.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 */
public class GerenciaFornecedor implements FornecedorCopyable {
	
	/**O método instancia um objeto do tipo Fornecedor utilizando as entradas do usuário que estão armazenadas em info. Se a lista de fornecedores 
	 * e o vetor que armazena as entradas do usuário não forem null o objeto do tipo fornecedor que foi instanciado é adicionado na 
	 * lista de fornecedores e é retornado true. Caso a lista de fornecedores seja igual a null uma mensagem exibindo que o fornecedor não foi cadastrado 
	 *e que existe um problema ao acessar o ArrayList é exibida, e é retornado false.
	 */
	@Override
	public boolean cadastrarFornecedor(ArrayList<Fornecedor> listaFornecedores, ArrayList<String> listaIds, String [] info) {
		
		Fornecedor novoFornecedor = new Fornecedor(listaIds, info[0], info[1], info[2]);
		
		if (listaFornecedores != null && info != null) {
			try {
				listaFornecedores.add(novoFornecedor);
				return true;
			} 
			catch(ArrayIndexOutOfBoundsException a){
				return false;
			}
		}
		else {
			return false;
		}
		
	}
	
	/**O método, caso a lista de fornecedores e o vetor que armazena as entradas do usuário forem diferentes null, percorre a lista de fornecedores 
	 * e verifica se existe um objeto na lista quem tem o atributo de id igual ao codigo de fornecedor que é passado como parâmetro. Se existir um
	 * fornecedor com o id igual ao código de fornecedor as informações são substituidas pelos novos valores que passados pelo usuário através do 
	 * vetor info. As substituições das informações são feitas utilizando os metódos de setters presentes na classe Fornecedor e é retornado true.
	 * Caso não exista um fornecedor com id igual ao codigo de fornecedor ou a lista de fornecedores e o vetor info tiverem valor null, o metódo 
	 * retorna false. 
	 */
	@Override
	public boolean editarFornecedor(ArrayList<Fornecedor> listaFornecedores, String codigoFornecedor, String [] info) {
		
		if(listaFornecedores != null && info!= null) {
			
			try {
				for(Fornecedor fornecedor : listaFornecedores) {
					if(fornecedor.getId().equals(codigoFornecedor)) {
						fornecedor.setNome(info[0]);
						fornecedor.setCnpj(info[1]);
						fornecedor.setEndereco(info[2]);
						return true;
					}else {
						return false;
					}
				}
			}
			catch(ArrayIndexOutOfBoundsException a){
				return false;
			}
			
		}else {
		}
		return false;
	}
	
	/**Se a lista de fornecedores e a lista de id's forem diferentes de null, um for each percorre os objetos da lista de fornecedores e verifica se
	 * o atributo de id dos objetos armazenados na lista é igual ao codigo de fornecedor que foi passado como parâmetro. Se o id do objeto for igual
	 * ao código de fornecedor o objeto é removido da lista de fornecedores, seu id é removido da lista de id's e a função retorna true. Caso não exista
	 * um fornecedor com id igual ao código de fornecedor que foi passado como parâmetro ou a lista de fornecedores e a lista de id's tiverem valor null
	 * a função retorna false.
	 */
	@Override
	public boolean excluirFornecedor(ArrayList<Fornecedor> listaFornecedores, ArrayList<String> listaIds, String codigoFornecedor) {
		
		if(listaFornecedores != null && listaIds!= null) {
			
			try {
				for(Fornecedor fornecedor : listaFornecedores) {
					if(fornecedor.getId().equals(codigoFornecedor)) {
						int index = listaFornecedores.indexOf(fornecedor);
						listaFornecedores.remove(index);
						listaIds.remove(codigoFornecedor);
						return true;
					}
					else {
						return false;
					}
				}
			}
			catch(ArrayIndexOutOfBoundsException a) {
				return false;
			}
		}
		return false;
	}

}
