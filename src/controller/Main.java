/***************************
Autores: Gabriel Cordeiro Moraes e Luis Fernando do Rosario Cintra
Componente Curricular: EXA863 MI Programação
Concluido em: 10/05/2022
Declaro que este código foi elaborado por nós de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************/
package controller;

import PreCadastro.PreCadastro;
import exceptions.ErroGrave;
import exceptions.EscolhaIncorreta;
import exceptions.FormatoDataInvalido;
import exceptions.FormatoHorarioInvalido;
import exceptions.FormatoIngredientesInvalido;
import exceptions.FormatoQuantidadeInvalido;
import exceptions.FornecedorNaoCadastrado;
import exceptions.LoginJaCadastrado;
import exceptions.ProdutoNaoCadastrado;
import exceptions.QuantidadeInvalida;
import exceptions.QuantidadeProdutosInsuficiente;
import exceptions.RelatorioNaoGerado;
import exceptions.VendaNaoCadastrada;
import exceptions.NaoEncontrado;
import exceptions.PratoNaoCadastrado;
import exceptions.PrecoInvalido;
import model.BancoDeDados;
import model.Funcionario;
import model.Gerente;
import model.Login;
import model.Usuario;
import view.CardapioView;
import view.FornecedorView;
import view.LoginView;
import view.ProdutosView;
import view.SubMenuView;
import view.UsuarioView;
import view.VendaView;

/**Principal classe do sistema. Responsável por fazer a chamada das demais classes e métodos que serão compilados e posteriormente interpretados pela Java
 * Virtual Machine.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 */
public class Main {
	
	/**Primeiro e principal método que será executado pela Java Virtual Machine.
	 * 
	 * @param args Possiveis parâmetros que podem ser passados para a aplicação a partir da linha de comando.
	 * @throws ProdutoNaoCadastrado 
	 */
	public static void main(String[] args) {
	
		//Intancio as listas
		BancoDeDados dados = new BancoDeDados();
		PreCadastro preCadastro = new PreCadastro();
		preCadastro.PreCadastrarFornecedores(dados);
		preCadastro.PreCadastrarProdutos(dados);
		preCadastro.PreCadastrarPratos(dados);
		preCadastro.preCadastrarVendas(dados);
		
		while(true) {
			
			//Loga o Usuario no sistema
			Login login = new Login(dados.getListaUsuarios());
			Usuario usuarioLogado;
			do{
				String[] infoLogin = LoginView.logar();
				usuarioLogado = login.autenticarLogin(dados.getListaUsuarios(), infoLogin);
				if(usuarioLogado == null) {
					System.out.println("Erro no Login! \n Tente novamente!");
				}
			}while(usuarioLogado == null);
			boolean logado = true;
					
			while(logado) {
				if(usuarioLogado instanceof Gerente) {
					
					int decisao[] = Menu.gerente();
					if(decisao[0] == 1) {
						switch(decisao[1]) {
						case 1:
							System.out.println("Cadastrando Fornecedor");
							String[] infoCadastroFornecedor = FornecedorView.cadastrarFornecedor();
							try {
								((Gerente) usuarioLogado).cadastrarFornecedor(dados.getListaFornecedores(), dados.getListaIds(), infoCadastroFornecedor);
							} catch (ErroGrave e) {
								System.out.println(e.toString());
							}
							break;
						case 2:
							System.out.println("Editando Fornecedor");
							String codigoFornecedorEdit = FornecedorView.buscaFornecedor();
							String [] infoEditFornecedor = FornecedorView.cadastrarFornecedor();
							try {
								((Gerente) usuarioLogado).editarFornecedor(dados.getListaFornecedores(), codigoFornecedorEdit, infoEditFornecedor);
							} catch (ErroGrave | NaoEncontrado e) {
								System.out.println(e.toString());
							}
							break;
						case 3:
							System.out.println("Excluindo Fornecedor");
							String codigoFornecedorDel = FornecedorView.buscaFornecedor();
							try {
								((Gerente) usuarioLogado).excluirFornecedor(dados.getListaFornecedores(),dados.getListaIds(), codigoFornecedorDel);
							} catch (ErroGrave | NaoEncontrado e) {
								System.out.println(e.toString());
							}
							break;
						case 4:
							break;
						}
						
					}
					
					else if(decisao[0] == 2) {
						switch(decisao[1]) {
						case 1:
							System.out.println("Cadastrando Vendas");
							String[] info = VendaView.cadastrarVenda();
							try {
								((Gerente) usuarioLogado).cadastrarVenda(dados.getListaVendas(), dados.getListaIds(), dados.getCardapio(), info, dados.getListaProdutos());
							} catch (PratoNaoCadastrado | QuantidadeProdutosInsuficiente | ErroGrave e) {
								System.out.println(e.toString());
							}
							break;
						case 2:
							System.out.println("Editando Vendas");
							String codigoVendaEdit = VendaView.buscaVenda();
							String [] infoEditVenda = VendaView.editarVenda();
							try {
								((Gerente) usuarioLogado).editarVenda(dados.getListaVendas(), dados.getCardapio(),codigoVendaEdit, infoEditVenda, dados.getListaProdutos());
							} catch (FormatoDataInvalido | FormatoHorarioInvalido | PratoNaoCadastrado
									| QuantidadeProdutosInsuficiente | ErroGrave | VendaNaoCadastrada e) {
								System.out.println(e.toString());
							}
							break;
						case 3:
							System.out.println("Excluindo Vendas");
							String codigoVendaDel = VendaView.buscaVenda();
							try {
								((Gerente) usuarioLogado).excluirVenda(dados.getListaVendas(), dados.getListaIds(), codigoVendaDel);
							} catch (VendaNaoCadastrada | ErroGrave e) {
								System.out.println(e.toString());
							}
							break;
						case 4:
							break;
						}
					}
					else if(decisao[0] == 3) {
						switch(decisao[1]) {
						case 1:
							System.out.println("Cadastrando Usuario");
							String [] infoUsuario = UsuarioView.cadastraUsuario();
							try {
								((Gerente) usuarioLogado).cadastrarUsuario(dados.getListaUsuarios(), dados.getListaIds(), infoUsuario);
							}catch(EscolhaIncorreta | LoginJaCadastrado | ErroGrave a) {
								System.out.println(a.toString());
							}
							break;
						case 2:
							System.out.println("Editando Usuario");
							String codigoUsuarioEdit = UsuarioView.buscaUsuario();
							String [] infoEditUsuario = UsuarioView.editaUsuario();
							try {
								((Gerente) usuarioLogado).editarUsuario(dados.getListaUsuarios(), codigoUsuarioEdit, infoEditUsuario);
							} catch (NaoEncontrado | ErroGrave e) {
								System.out.println(e.toString());
							}
							break;
						case 3:
							System.out.println("Excluindo Usuario");
							String codigoUsuarioDel = UsuarioView.buscaUsuario();
							try {
								((Gerente) usuarioLogado).excluirUsuario(dados.getListaUsuarios(), dados.getListaIds(), codigoUsuarioDel);
							} catch (ErroGrave | NaoEncontrado e) {
								System.out.println(e.toString());
							}
							break;
						case 4:
							break;
						}
					}
					else if(decisao[0] == 4) {
						switch(decisao[1]) {
						case 1:
							System.out.println("Cadastrando Prato");
							String[] infoCadastro = CardapioView.cadastrarPrato();
							try {
								((Gerente) usuarioLogado).cadastrarPrato(dados.getCardapio(), dados.getListaIds(), dados.getListaProdutos(), infoCadastro);
							} catch (PrecoInvalido | QuantidadeInvalida | FormatoIngredientesInvalido
									| ErroGrave | NumberFormatException | ProdutoNaoCadastrado e) {
								System.out.println(e.toString());
							}
							break;
						case 2:
							System.out.println("Editando Prato");
							String codigoPratoEdit = CardapioView.buscaPrato();
							String [] infoEdicao = CardapioView.editarPrato();
							try {
								((Gerente) usuarioLogado).editarPrato(dados.getCardapio(), dados.getListaProdutos(), codigoPratoEdit, infoEdicao);
							} catch (PrecoInvalido | QuantidadeInvalida | FormatoIngredientesInvalido | ErroGrave
									| PratoNaoCadastrado | ProdutoNaoCadastrado e) {
								System.out.println(e.toString());
							}
							break;
						case 3:
							System.out.println("Excluindo Prato");
							String codigoPratoDel = CardapioView.buscaPrato();
							try {
								((Gerente) usuarioLogado).excluirPrato(dados.getCardapio(), dados.getListaIds(), codigoPratoDel);
							} catch (ErroGrave | PratoNaoCadastrado e) {
								System.out.println(e.toString());
							}
							break;
						case 4:
							break;
						}
					}
					else if(decisao[0] == 5) {
						switch(decisao[1]) {
						case 1:
							System.out.println("Cadastrando Produtos");
							String[] infoCadastroProduto = ProdutosView.cadastrarProduto();
							try {
								((Gerente) usuarioLogado).cadastrarProduto(dados.getListaProdutos(), dados.getListaIds(), infoCadastroProduto, dados.getListaFornecedores());
							} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida
									| FormatoDataInvalido | FornecedorNaoCadastrado | ErroGrave e) {
								System.out.println(e.toString());
							}
							break;
						case 2:
							System.out.println("Editando Produtos");
							String codigoProdutoEdit = ProdutosView.buscaProduto();
							String [] infoProdutoEdit = ProdutosView.editarProduto();
							try {
								((Gerente) usuarioLogado).editarProduto(dados.getListaProdutos(), codigoProdutoEdit, infoProdutoEdit, dados.getListaFornecedores());
							} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida
									| FormatoDataInvalido | FornecedorNaoCadastrado | ErroGrave e) {
								System.out.println(e.toString());
							}
							break;
						case 3:
							System.out.println("Excluindo Produtos");
							String codigoProdutoDel = ProdutosView.buscaProduto();
							try {
								((Gerente) usuarioLogado).excluirProduto(dados.getListaProdutos(), dados.getListaIds(), codigoProdutoDel);
							} catch (ProdutoNaoCadastrado | ErroGrave e) {
								System.out.println(e.toString());
							}
							break;
						case 4:
							break;
						}
					}
					else if(decisao[0] == 6) {
						switch(decisao[1]) {
						case 1:
							((Gerente) usuarioLogado).mostrarCardapio(dados.getCardapio());
							break;
						case 2:
							((Gerente) usuarioLogado).listarProduto(dados.getListaProdutos());
							break;
						case 3:
							((Gerente) usuarioLogado).listarVenda(dados.getListaVendas());
							break;
						case 4:
							((Gerente) usuarioLogado).listarFornecedor(dados.getListaFornecedores());
							break;
						case 5:
							((Gerente) usuarioLogado).listarUsuario(dados.getListaUsuarios());
							break;
						case 6:
							break;
						}
					}
					else if(decisao[0] == 7) {
						switch(decisao[1]) {
						case 1:
							try {
								((Gerente) usuarioLogado).vendasTotal(dados.getListaVendas());
								System.out.println("Relatorio gerado com sucesso!!!");
							} catch (ErroGrave | RelatorioNaoGerado e1) {
								System.out.println(e1.toString());
							}
							break;
						
						case 2:
							try {
								((Gerente) usuarioLogado).vendasPorPeriodo(dados.getListaVendas());
								System.out.println("Relatoris gerados com sucesso!!!");
							} catch (ErroGrave e1) {
								System.out.println(e1.toString());
							}
							break;
							
						case 3:
							try {
								((Gerente) usuarioLogado).vendasPorTipoDePrato(dados.getListaVendas());
								System.out.println("Relatorio gerado com sucesso!!!");
							} catch (ErroGrave | RelatorioNaoGerado e1) {
								System.out.println(e1.toString());
							}
							break;
							
						case 4:
							try {
								((Gerente) usuarioLogado).estoqueTotal(dados.getListaProdutos());
								System.out.println("Relatorio gerado com sucesso!!!");
							} catch (RelatorioNaoGerado | ErroGrave e) {
								System.out.println(e.toString());
							}
							break;
							
						case 5:
							try {
								((Gerente) usuarioLogado).estoquePorProduto(dados.getListaProdutos());
								System.out.println("Relatorio gerado com sucesso!!!");
							} catch (RelatorioNaoGerado | ErroGrave e) {
								System.out.println(e.toString());
							}
							break;
							
						case 6:
							try {
								((Gerente) usuarioLogado).estoqueProdutosPertoDeVencer(dados.getListaProdutos());
								System.out.println("Relatorio gerado com sucesso!!!");
							} catch (ErroGrave | RelatorioNaoGerado e) {
								System.out.println(e.toString());
							}
							break;
							
						case 7:
							try {
								((Gerente) usuarioLogado).fornecedorPorProduto(dados.getListaProdutos());
								System.out.println("Relatorio gerado com sucesso!!!");
							} catch (RelatorioNaoGerado | ErroGrave e) {
								System.out.println(e.toString());
							}
							break;
							
						case 8:
							try {
								((Gerente) usuarioLogado).fornecedorPorFornecedor(dados.getListaFornecedores());
								System.out.println("Relatorio gerado com sucesso!!!");
							} catch (RelatorioNaoGerado | ErroGrave e) {
								System.out.println(e.toString());
							}
							break;
						
						case 9:
							break;
						}
						}
					else if(decisao[0] == 8) {
						logado = false;
						}
				}
				else if(usuarioLogado instanceof Funcionario) {
					//Menu de Funcionario
					int decisao[] = Menu.funcionario();
					if(decisao[0] == 1) {
						switch(decisao[1]) {
						case 1:
							System.out.println("Cadastrando Vendas");
							String[] info = VendaView.cadastrarVenda();
							try {
								((Funcionario) usuarioLogado).cadastrarVenda(dados.getListaVendas(), dados.getListaIds(), dados.getCardapio(), info, dados.getListaProdutos());
							} catch (PratoNaoCadastrado | QuantidadeProdutosInsuficiente | ErroGrave e) {
								System.out.println(e.toString());
							}
							break;
						case 2:
							System.out.println("Editando Vendas");
							String codigoVendaEdit = VendaView.buscaVenda();
							String [] infoEditVenda = VendaView.editarVenda();
							try {
								((Funcionario) usuarioLogado).editarVenda(dados.getListaVendas(), dados.getCardapio(),codigoVendaEdit, infoEditVenda, dados.getListaProdutos());
							} catch (FormatoDataInvalido | FormatoHorarioInvalido | PratoNaoCadastrado
									| QuantidadeProdutosInsuficiente | ErroGrave | VendaNaoCadastrada e) {
								System.out.println(e.toString());
							}
							break;
						case 3:
							System.out.println("Excluindo Vendas");
							String codigoVendaDel = VendaView.buscaVenda();
							try {
								((Funcionario) usuarioLogado).excluirVenda(dados.getListaVendas(), dados.getListaIds(), codigoVendaDel);
							} catch (VendaNaoCadastrada | ErroGrave e) {
								System.out.println(e.toString());
							}
							break;
						case 4:
							break;
						}
					}else if(decisao[0] == 2) {
							switch(decisao[1]) {
							case 1:
								((Funcionario) usuarioLogado).mostrarCardapio(dados.getCardapio());
								break;
							case 2:
								((Funcionario) usuarioLogado).listarProduto(dados.getListaProdutos());
								break;
							case 3:
								((Funcionario) usuarioLogado).listarVenda(dados.getListaVendas());
								break;
							case 4:
								((Funcionario) usuarioLogado).listarFornecedor(dados.getListaFornecedores());
								break;
							case 5:
								((Funcionario) usuarioLogado).listarUsuario(dados.getListaUsuarios());
								break;
							case 6:
								break;
							}
						}
						else if(decisao[0] == 3) {
							logado = false;
							}
					}

				}
			}
			}
		}

