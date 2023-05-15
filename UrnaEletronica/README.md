## Getting Started

Bem vindo ao guia do projeto Urna eletronica
Integrantes: Erick Juan e João Pedro Brandão.

A urna eletronica tem sua main com o nome de Sistema, que inicializa o programa.
Para realizar a votação, escolha um dos CPFs no arquivo eleitores.txt e insira no campo de codigo de usuario.
Escolha o candidato a ser votado e confirme seu voto.
repita o processo até que todos votem.
Ao finalizar a eleição, insira a senha 123 no campo de finalizar a eleição para exibir o resultado da eleição.
Note que há um botão para reiniciar toda a eleição, zerando todos os dados de voto, permitindo todos os eleitores votarem novamente e tirando os votos dos vilões.

O Sistema gera todos os objetos Eleitores e Viloes, cujo nos construtores estão programados para escrever seus dados em seus respectivos Txts, e logo em seguida, utiliza um metodo da Classe Seguranca para verificar se os dados não foram alterados. Caso algum dado do arquivo Txt tenha sido alterado, sua hash sera tambem alterada e o programa encerrará imprimindo a mensagem "Os dados de origem foram alterados, o programa será encerrado agora."

Gostaria de criar uma mensagem usando JOptionPane para exibir uma mensagem ao inves de imprimir. Porem, devido ao tempo, não consegui implementar.

Outra coisa que não deu tempo de implementar foi a utilização de hashs para cada ação da eleição. Por exemplo, realizar um teste se a hash é igual antes de efetuar o voto. Por mais que eu saiba como fazer, infelizmente não dará tempo. Então apenas fiz a verificação dos Txts no inicio de cada vez que o programa da eleição é aberto.

Infelizmente, não consegui "de ultima hora" organizar as pastas em view, model e src. Acabou ficando tudo em uma pasta só.