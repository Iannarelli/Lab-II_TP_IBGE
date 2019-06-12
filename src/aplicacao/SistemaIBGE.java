package aplicacao;

import java.util.Scanner;

import classes.Indicador;
import classes.Pessoa;
import manipulacaoArquivo.ArquivoTextoEscrita;
import manipulacaoArquivo.ArquivoTextoLeitura;
import manipulacaoDados.ManipulaDados;

public class SistemaIBGE {

	public static void main(String[] args) {
		int op = 0;
		long identidade = 0;
		boolean mostraMenu = true;
		String[] categorias = new String[5];
		String[] dados = new String[7];
		@SuppressWarnings("unused")
		String lixo;
		Pessoa pessoa;
		Scanner leitor = new Scanner(System.in);
		ArquivoTextoLeitura leitorArquivo = new ArquivoTextoLeitura();
		ArquivoTextoEscrita escritorArquivo = new ArquivoTextoEscrita();
		System.out.println("Bem vindo ao Sistema CENSO 2020 do IBGE!\n");
		System.out.println("Para começar, informe o nome do arquivo da base de dados: ");
		String arquivo = leitor.nextLine();
		ManipulaDados manipulador = new ManipulaDados(leitorArquivo, escritorArquivo, arquivo);
		leitorArquivo.abrirArquivo(arquivo);
		manipulador.carregaDadosArquivo();
		leitorArquivo.fecharArquivo();
		do {
			if (mostraMenu == true) {
				System.out.print("\n\t\t\tMENU DE OPÇÕES\n\n");
				System.out.print("\t\t1- Inserir dados de uma pessoa\n\t\t2- Inserir dados de diversas pessoas\n\t\t"
						+ "3- Pesquisar dados de uma pessoa\n\t\t4- Alterar dados de uma pesoa\n\t\t5- Excluir dados de uma pessoa\n\t\t"
						+ "6- Relatório de categorização\n\t\t7- Relatório estatístico\n\t\t8- Sair\n\nInforme a opção desejada: ");
				do {
					op = leitor.nextInt();
					lixo = leitor.nextLine();
					if (op < 1 || op > 8)
						System.out.print("Opção inválida. Informe novamente uma das opção entre 1 e 5: ");
				} while (op < 1 || op > 8);
			}
			switch (op) {
			case 1:
				if (mostraMenu == true) {
					System.out.print("\nInforme os dados abaixo:\nIdentidade: ");
					do {
						dados[0] = String.valueOf(leitor.nextLong());
						lixo = leitor.nextLine();
						if (Long.parseLong(dados[0]) <= 0)
							System.out.print(
									"\tInformação inválida. Informe novamente a identidade (número maior que zero): ");
					} while (Long.parseLong(dados[0]) <= 0);
				} else {
					System.out.print("\nInforme os dados abaixo (para sair, escreva \"sair\"):\nIdentidade: ");
					do {
						dados[0] = leitor.nextLine();
						if (dados[0].equalsIgnoreCase("sair")) {
							mostraMenu = true;
							break;
						} else {
							if (Long.parseLong(dados[0]) > 0)
								dados[0] = String.valueOf(dados[0]);
							else
								System.out.print(
										"\tInformação inválida. Informe novamente a identidade (número maior que zero): ");
						}
					} while (!dados[0].equalsIgnoreCase("sair") && Long.parseLong(dados[0]) <= 0);
				}

				if (!dados[0].equalsIgnoreCase("sair")) {
					if (manipulador.getArvore().pesquisar(Long.parseLong(dados[0])) == null) {

						System.out.print("Nome completo: ");
						dados[1] = leitor.nextLine();

						System.out.print("Sexo ( m / f ): ");
						do {
							dados[2] = String.valueOf(leitor.next().charAt(0));
							if (!dados[2].equalsIgnoreCase("m") && !dados[2].equalsIgnoreCase("M")
									&& !dados[2].equalsIgnoreCase("f") && !dados[2].equalsIgnoreCase("F"))
								System.out.print("\tInformação inválida. Informe novamente o sexo ( m / f ): ");
						} while (!dados[2].equalsIgnoreCase("m") && !dados[2].equalsIgnoreCase("M")
								&& !dados[2].equalsIgnoreCase("f") && !dados[2].equalsIgnoreCase("F"));

						System.out.print("Idade: ");
						do {
							dados[3] = String.valueOf(leitor.nextInt());
							lixo = leitor.nextLine();
							if (Integer.parseInt(dados[3]) < 0)
								System.out.print("\tInformação inválida. Informe novamente a idade (valor não nulo): ");
						} while (Integer.parseInt(dados[3]) < 0);

						System.out.print("Tipo de moradia (rural / urbana): ");
						do {
							dados[4] = leitor.nextLine();
							if (!dados[4].equalsIgnoreCase("rural") && !dados[4].equalsIgnoreCase("urbana"))
								System.out.print(
										"\tInformação inválida. Informe novamente o tipo de moradia (rural / urbana): ");
						} while (!dados[4].equalsIgnoreCase("rural") && !dados[4].equalsIgnoreCase("urbana"));

						System.out.print("Estado civil (solteiro / casado / divorciado / viúvo): ");
						do {
							dados[5] = leitor.nextLine();
							if (!dados[5].equalsIgnoreCase("solteiro") && !dados[5].equalsIgnoreCase("solteira")
									&& !dados[5].equalsIgnoreCase("casado") && !dados[5].equalsIgnoreCase("casada")
									&& !dados[5].equalsIgnoreCase("divorciado")
									&& !dados[5].equalsIgnoreCase("divorciada") && !dados[5].equalsIgnoreCase("viuvo")
									&& !dados[5].equalsIgnoreCase("viuva") && !dados[5].equalsIgnoreCase("viúvo")
									&& !dados[5].equalsIgnoreCase("viúva"))
								System.out.print(
										"\tInformação inválida. Informe novamente o estado civil (solteiro / casado / divorciado /"
												+ " viúvo): ");
						} while (!dados[5].equalsIgnoreCase("solteiro") && !dados[5].equalsIgnoreCase("solteira")
								&& !dados[5].equalsIgnoreCase("casado") && !dados[5].equalsIgnoreCase("casada")
								&& !dados[5].equalsIgnoreCase("divorciado") && !dados[5].equalsIgnoreCase("divorciada")
								&& !dados[5].equalsIgnoreCase("viuvo") && !dados[5].equalsIgnoreCase("viuva") /*************AQUI***************/
								&& !dados[5].equalsIgnoreCase("viúvo") && !dados[5].equalsIgnoreCase("viúva"));/*************AQUI***************/

						System.out.print("Raça (parda / preta / branca / amarela / indígena): ");
						do {
							dados[6] = leitor.nextLine();
							if (!dados[6].equalsIgnoreCase("parda") && !dados[6].equalsIgnoreCase("pardo")
									&& !dados[6].equalsIgnoreCase("preta") && !dados[6].equalsIgnoreCase("preto")
									&& !dados[6].equalsIgnoreCase("branca") && !dados[6].equalsIgnoreCase("branco")
									&& !dados[6].equalsIgnoreCase("amarela") && !dados[6].equalsIgnoreCase("amarelo")
									&& !dados[6].equalsIgnoreCase("indigena") && !dados[6].equalsIgnoreCase("indigeno")
									&& !dados[6].equalsIgnoreCase("indígena") && !dados[6].equalsIgnoreCase("indígeno"))
								System.out.print(
										"\tInformação inválida. Informe novamente a raça (parda / preta / branca /"
												+ " amarela / indígena): ");
						} while (!dados[6].equalsIgnoreCase("parda") && !dados[6].equalsIgnoreCase("pardo")
								&& !dados[6].equalsIgnoreCase("preta") && !dados[6].equalsIgnoreCase("preto")
								&& !dados[6].equalsIgnoreCase("branca") && !dados[6].equalsIgnoreCase("branco")
								&& !dados[6].equalsIgnoreCase("amarela") && !dados[6].equalsIgnoreCase("amarelo")
								&& !dados[6].equalsIgnoreCase("indigena") && !dados[6].equalsIgnoreCase("indigeno")
								&& !dados[6].equalsIgnoreCase("indígena") && !dados[6].equalsIgnoreCase("indígeno"));
						manipulador.pessoaNova(dados);
					} else {
						System.out.println("A identidade " + dados[0] + " já está cadastrada."); /*************AQUI***************/
						mostraMenu = true;
					}
				}
				break;
			case 2:
				mostraMenu = false;
				op = 1;
				break;
			case 3:
				if (mostraMenu == true)
					System.out.print("Para pesquisa, informe a identidade: ");
				else
					op = 4;
				do {
					identidade = leitor.nextLong();
					lixo = leitor.nextLine();
					if (identidade <= 0) {
						System.out.print(
								"\tInformação inválida. Informe novamente a identidade (número maior que zero): ");
					}
				} while (identidade <= 0);
				if (manipulador.getArvore().pesquisar(identidade) != null)
					System.out.println(manipulador.getArvore().pesquisar(identidade).toString());
				else {
					System.out.println("A identidade " + identidade + " não consta nos registros.");
					mostraMenu = true;
				}
				break;
			case 4:
				int opAtualizar;
				if (mostraMenu == true) {
					System.out.print("Para atualização de dados, informe a identidade para verificar os dados atuais: ");
					mostraMenu = false;
					op = 3;
				} else {
					do {
						System.out.print("\nOs dados atualizáveis são:\n\t1- Nome\n\t2- Sexo\n\t3- Idade\n\t4- Moradia\n\t"
										+ "5- Estado civil\n\t6- Raça\n\t7- Cancelar\nInforme a opção desejada: ");
						do {
							opAtualizar = leitor.nextInt();
							lixo = leitor.nextLine();
							if (opAtualizar < 1 || opAtualizar > 7)
								System.out.print("Opção inválida. Informe novamente uma das opção entre 1 e 8: ");
						} while (opAtualizar < 1 || opAtualizar > 7);
						switch (opAtualizar) {
						case 1:
							System.out.print("Informe o nome para atualização: ");
							dados[1] = leitor.nextLine();
							if (manipulador.getArvore().pesquisar(identidade) != null) {
								manipulador.getArvore().pesquisar(identidade).setNome(dados[1]);
								manipulador.armazenaDadosArquivo();
							}
							break;
						case 2:
							System.out.print("Informe o sexo para atualização ( m / f ): ");
							do {
								dados[2] = String.valueOf(leitor.next().charAt(0));
								if (!dados[2].equalsIgnoreCase("m") && !dados[2].equalsIgnoreCase("M")
										&& !dados[2].equalsIgnoreCase("f") && !dados[2].equalsIgnoreCase("F"))
									System.out.print("\tInformação inválida. Informe novamente o sexo ( m / f ): ");
							} while (!dados[2].equalsIgnoreCase("m") && !dados[2].equalsIgnoreCase("M")
									&& !dados[2].equalsIgnoreCase("f") && !dados[2].equalsIgnoreCase("F"));
							if (manipulador.getArvore().pesquisar(identidade) != null) {
								manipulador.getArvore().pesquisar(identidade).setSexo(dados[2].charAt(0));
								manipulador.armazenaDadosArquivo();
							}
							break;
						case 3:
							System.out.print("Informe a idade para atualização: ");
							do {
								dados[3] = String.valueOf(leitor.nextInt());
								lixo = leitor.nextLine();
								if (Integer.parseInt(dados[3]) < 0)
									System.out.print("\tInformação inválida. Informe novamente a idade (valor não nulo): ");
							} while (Integer.parseInt(dados[3]) < 0);
							if (manipulador.getArvore().pesquisar(identidade) != null) {
								manipulador.getArvore().pesquisar(identidade).setIdade(Integer.parseInt(dados[3]));
								manipulador.armazenaDadosArquivo();
							}
							break;
						case 4:
							System.out.print("Tipo de moradia (rural / urbana): ");
							do {
								dados[4] = leitor.nextLine();
								if (!dados[4].equalsIgnoreCase("rural") && !dados[4].equalsIgnoreCase("urbana"))
									System.out.print(
											"\tInformação inválida. Informe novamente o tipo de moradia (rural / urbana): ");
							} while (!dados[4].equalsIgnoreCase("rural") && !dados[4].equalsIgnoreCase("urbana"));
							if (manipulador.getArvore().pesquisar(identidade) != null) {
								manipulador.getArvore().pesquisar(identidade).setMoradia(dados[4]);
								manipulador.armazenaDadosArquivo();
							}
							break;
						case 5:
							System.out.print("Estado civil (solteiro / casado / divorciado / viúvo): ");
							do {
								System.out.println(dados[5]);
								if (!dados[5].equalsIgnoreCase("solteiro") && !dados[5].equalsIgnoreCase("solteira")
										&& !dados[5].equalsIgnoreCase("casado") && !dados[5].equalsIgnoreCase("casada")
										&& !dados[5].equalsIgnoreCase("divorciado")	&& !dados[5].equalsIgnoreCase("divorciada")
										&& !dados[5].equalsIgnoreCase("viuvo") && !dados[5].equalsIgnoreCase("viuva")
										&& !dados[5].equalsIgnoreCase("viúvo") && !dados[5].equalsIgnoreCase("viúva"))
									System.out.print(
											"\tInformação inválida. Informe novamente o estado civil (solteiro / casado / divorciado /"
													+ " viúvo): ");
							} while (!dados[5].equalsIgnoreCase("solteiro") && !dados[5].equalsIgnoreCase("solteira")
									&& !dados[5].equalsIgnoreCase("casado") && !dados[5].equalsIgnoreCase("casada")
									&& !dados[5].equalsIgnoreCase("divorciado") && !dados[5].equalsIgnoreCase("divorciada")
									&& !dados[5].equalsIgnoreCase("viuvo") && !dados[5].equalsIgnoreCase("viuva") /*************AQUI***************/
									&& !dados[5].equalsIgnoreCase("viúvo") && !dados[5].equalsIgnoreCase("viúva"));/*************AQUI***************/
							if (manipulador.getArvore().pesquisar(identidade) != null) {
								manipulador.getArvore().pesquisar(identidade).setEstadoCivil(dados[5]);
								manipulador.armazenaDadosArquivo();
							}
							break;
						case 6:
							System.out.print("Raça (parda / preta / branca / amarela / indígena): ");
							do {
								dados[6] = leitor.nextLine();
								if (!dados[6].equalsIgnoreCase("parda") && !dados[6].equalsIgnoreCase("pardo")
										&& !dados[6].equalsIgnoreCase("preta") && !dados[6].equalsIgnoreCase("preto")
										&& !dados[6].equalsIgnoreCase("branca") && !dados[6].equalsIgnoreCase("branco")
										&& !dados[6].equalsIgnoreCase("amarela") && !dados[6].equalsIgnoreCase("amarelo")
										&& !dados[6].equalsIgnoreCase("indigena") && !dados[6].equalsIgnoreCase("indigeno")
										&& !dados[6].equalsIgnoreCase("indígena") && !dados[6].equalsIgnoreCase("indígeno"))
									System.out.print(
											"\tInformação inválida. Informe novamente a raça (parda / preta / branca /"
													+ " amarela / indígena): ");
							} while (!dados[6].equalsIgnoreCase("parda") && !dados[6].equalsIgnoreCase("pardo")
									&& !dados[6].equalsIgnoreCase("preta") && !dados[6].equalsIgnoreCase("preto")
									&& !dados[6].equalsIgnoreCase("branca") && !dados[6].equalsIgnoreCase("branco")
									&& !dados[6].equalsIgnoreCase("amarela") && !dados[6].equalsIgnoreCase("amarelo")
									&& !dados[6].equalsIgnoreCase("indigena") && !dados[6].equalsIgnoreCase("indigeno")
									&& !dados[6].equalsIgnoreCase("indígena") && !dados[6].equalsIgnoreCase("indígeno"));
							if (manipulador.getArvore().pesquisar(identidade) != null) {
								manipulador.getArvore().pesquisar(identidade).setRaca(dados[6]);
								manipulador.armazenaDadosArquivo();
							}
							break;
						case 7:
							mostraMenu = true;
							break;
						default:
							break;
						}
					} while (opAtualizar != 7);
				}
				break;
			case 5:
				System.out.print("Para excluir um registro, digite a identidade da pessoa: ");
				do {
					identidade = leitor.nextLong();
					lixo = leitor.nextLine();
					if (identidade <= 0)
						System.out.print("\tInformação inválida. Informe novamente a identidade (número maior que zero): ");
				} while (identidade <= 0);
				pessoa = manipulador.getArvore().pesquisar(identidade);
				if(pessoa == null) {
					System.out.println("A identidade " + identidade + " não consta nos registros.");
				} else {
					manipulador.getArvore().remover(identidade);
					dados[0] = String.valueOf(pessoa.getIdentidade());
					dados[1] = pessoa.getNome();
					dados[2] = String.valueOf(pessoa.getSexo());
					dados[3] = String.valueOf(pessoa.getIdade());
					dados[4] = pessoa.getMoradia();
					dados[5] = pessoa.getEstadoCivil();
					dados[6] = pessoa.getRaca();
					categorias = manipulador.defineCategorias(dados);
					for (int i = 0; i < 5; i++)
						manipulador.getEstruturaLista().getLista(categorias[i]).retirar(pessoa.getIdentidade());
					manipulador.armazenaDadosArquivo();
				}
				break;
			case 6:
			case 7:
				Indicador indicadores = manipulador.geraIndicadores();
				float populacaoTotal = indicadores.getPopulacaoTotal();
				float populacaoF = indicadores.getPopulacaoF();
				float populacaoM = indicadores.getPopulacaoM();
				float ate12 = indicadores.getAte12();
				float de13a19 = indicadores.getDe13a19();
				float de20a25 = indicadores.getDe20a25();
				float de26a30 = indicadores.getDe26a30();
				float de31a45 = indicadores.getDe31a45();
				float de46a65 = indicadores.getDe46a65();
				float mais65 = indicadores.getMais65();
				float rural = indicadores.getRural();
				float urbana = indicadores.getUrbana();
				float solteiro = indicadores.getSolteiro();
				float casado = indicadores.getCasado();
				float divorciado = indicadores.getDivorciado();
				float viuvo = indicadores.getViuvo();
				float parda = indicadores.getParda();
				float preta = indicadores.getPreta();
				float branca = indicadores.getBranca();
				float amarela = indicadores.getAmarela();
				float indigena = indicadores.getIndigena();
				if(op == 6) {
				System.out.println("\n********** RELATÓRIO DE CATEGORIZAÇÃO **********");
				System.out.printf("População total: %.0f\n", populacaoTotal);
				System.out.printf("____________________________________________________________________________________________________\n");
				System.out.printf("\nCaracterização\nSexo\nFeminino: %.0f (%.2f%%)\n", populacaoF, populacaoF/populacaoTotal*100);
				System.out.printf("Masculino: %.0f (%.2f%%)\n", populacaoM, populacaoM/populacaoTotal*100);
				System.out.printf("____________________________________________________________________________________________________\n");
				System.out.printf("\nIdade\n0 a 12 anos: %.0f (%.2f%%)\n", ate12, ate12/populacaoTotal*100);
				System.out.printf("13 a 19 anos: %.0f (%.2f%%)\n", de13a19, de13a19/populacaoTotal*100);
				System.out.printf("20 a 25 anos: %.0f (%.2f%%)\n", de20a25, de20a25/populacaoTotal*100);
				System.out.printf("26 a 30 anos: %.0f (%.2f%%)\n", de26a30, de26a30/populacaoTotal*100);
				System.out.printf("31 a 45 anos: %.0f (%.2f%%)\n", de31a45, de31a45/populacaoTotal*100);
				System.out.printf("46 a 65 anos: %.0f (%.2f%%)\n", de46a65, de46a65/populacaoTotal*100);
				System.out.printf("Mais de 65 anos: %.0f (%.2f%%)\n", mais65, mais65/populacaoTotal*100);
				System.out.printf("____________________________________________________________________________________________________\n");
				System.out.printf("\nMoradia\nRural: %.0f (%.2f%%)\n", rural, rural/populacaoTotal*100);
				System.out.printf("Urbana: %.0f (%.2f%%)\n", urbana, urbana/populacaoTotal*100);
				System.out.printf("____________________________________________________________________________________________________\n");
				System.out.printf("\nEstado Civil\nSolteiro(a): %.0f (%.2f%%)\n", solteiro, solteiro/populacaoTotal*100);
				System.out.printf("Casado(a): %.0f (%.2f%%)\n", casado, casado/populacaoTotal*100);
				System.out.printf("Divorciado(a): %.0f (%.2f%%)\n", divorciado, divorciado/populacaoTotal*100);
				System.out.printf("Viúvo(a): %.0f (%.2f%%)\n", viuvo, viuvo/populacaoTotal*100);
				System.out.printf("____________________________________________________________________________________________________\n");
				System.out.printf("\nRaça\nParda: %.0f (%.2f%%)\n", parda, parda/populacaoTotal*100);
				System.out.printf("Preta: %.0f (%.2f%%)\n", preta, preta/populacaoTotal*100);
				System.out.printf("Branca: %.0f (%.2f%%)\n", branca, branca/populacaoTotal*100);
				System.out.printf("Amarela: %.0f (%.2f%%)\n", amarela, amarela/populacaoTotal*100);
				System.out.printf("Indígena: %.0f (%.2f%%)\n", indigena, indigena/populacaoTotal*100);
				System.out.printf("____________________________________________________________________________________________________\n");
				}
				else {
					float totalIdadeF = indicadores.getTotalIdadeF();
					float totalIdadeM = indicadores.getTotalIdadeM();
					float mediaF = indicadores.getMediaF();
					float mediaM = indicadores.getMediaM();
					float mediaRural = indicadores.getMediaRural();
					float mediaUrbana = indicadores.getMediaUrbana();
					float mediaSolteiro = indicadores.getMediaSolteiro();
					float mediaCasado = indicadores.getMediaCasado();
					float desvioPadraoSolteiro = indicadores.getDesvioPadraoSolteiro();
					float desvioPadraoCasado = indicadores.getDesvioPadraoCasado();
				System.out.println("\n********** RELATÓRIO ESTATISTICO **********");
				System.out.printf("Média de idade geral: %.1f anos\n", (totalIdadeF+totalIdadeM)/populacaoTotal);
				System.out.printf("____________________________________________________________________________________________________\n");
				System.out.printf("\nCategorizada por sexo\nFeminino:\t%.1f anos\nMasculino:\t%.1f anos\n", 
						mediaF, mediaM);
				System.out.printf("____________________________________________________________________________________________________\n");
				System.out.printf("\nCategorizada por moradia\nRural:\t\t%.1f anos\nUrbana:\t\t%.1f anos\n", 
						mediaRural, mediaUrbana);
				System.out.printf("____________________________________________________________________________________________________\n");
				System.out.printf("\nSolteiros e casados\n\t\tMédia de idade\tDesvio padrão\nSolteiros:\t%.1f anos\t%.1f anos\n"
						+ "Casados:\t%.1f anos\t%.1f anos\n", mediaSolteiro, desvioPadraoSolteiro, mediaCasado, desvioPadraoCasado);
				System.out.printf("____________________________________________________________________________________________________\n");

				}
				break;
			case 8:
				System.out.println("\n\n\t\tATÉ A PRÓXIMA!!!\n\n");
				break;
			default:
				break;
			}
		} while (op != 8);
	leitor.close();
	}
}
