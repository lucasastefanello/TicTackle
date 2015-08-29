# TicTackle

## Especificação de Requisitos do projeto: Tic Tackle

Universidade Federal de Santa Catarina
Centro Tecnológico ​CTC
Departamento de Informática e Estatística ​INE
Curso de Sistemas de Informação
INE5608 ​Analise e Projeto de Sistemas

## INTRODUÇÃO

### Objetivo

Neste documento, apresenta-se a proposta de desenvolvimento de um jogo (software) que permita a criação e disputa de partidas em rede do jogo “Tic Tackle”.

O Jogo consiste em um programa multi-jogador, em que cada jogador deverá posicionar três peças em linha reta, sendo horizontal ou vertical, ou então posicionar as mesmas em posição diagonal. 

## VISÃO GERAL

### Arquitetura do programa

O programa consiste em um jogo, no qual serão permitidos dois jogadores, e será disponibilizado através do NetGames, com conexão remota e desenvolvido na linguagem de programação JAVA, orientada a objetos.

### Descrição do jogo

O jogo Tic Tackle é composto de um tabuleiro com 16 posições, onde cada jogador terá quatro peças e para vencer a partida deve formar um linha reta ou diagonal com três, das quatro peças. de percorrer uma trilha repleta de desafios. 

### Regras do jogo

O jogo será baseado em turnos, de no mínimo e máximo 2 jogadores para cada nova partida.

Novo Jogo: Para iniciar um novo jogo, o jogador deverá executar o programa. Após isso, um jogador poderá se conectar. 

Conectar a um jogo: Para conectar a um jogo já criado, o usuário deverá clicar em “jogar”, inserindo seu nome e aguardando um novo adversário se conectar;

O Tic Tackle contêm 16 casas (posições) a serem percorridas;

Ao iniciar o jogo, o jogador 1 será aquele que fez o login primeiro e terá o direito de começar a partida. 

Ganha o jogador que posicionar suas peças em linha reta (horizontal ou vertical) ou em linha diagonal.

## REQUISITOS DE SOFTWARE

### Requisitos funcionais

Requisito funcional 1 – Conectar: A aplicação deve permitir fazer a conexão com o server do NetGames.

Requisito funcional 2 – Iniciar partida: A tela principal conterá dois inputs para inserir o nome do jogadores e o server do NetGames. Ao lado conterá um botão “Iniciar partida” que levará o jogador a uma tela de espera até que um adversário se conecte.

Requisito funcional 3 - Jogar: A aplicação permite para cada jogador a possibilidade de mover uma peça por vez no tabuleiro. O que é considerado uma jogada.

Requisito funcional 4 - Reiniciar: A aplicação permite a qualquer momento reiniciar a partida, por meio de um botão na interface gráfica do usuário chamado (Reiniciar partida).

Requisito funcional 5 - Aceitar Reinicio: Quando o usuário solicita o reinicio da partida, o adversário pode aceitar o reinicio. Esta decisão é feita por meio de um botão na interface gráfica do usuário chamado (Aceitar reiniciar).

Requisito funcional 6 - Encerrar partida: A aplicação permite a qualquer momento encerrar 
a partida, por meio de um botão na interface gráfica do usuário chamado (Sair).

### Requisitos não funcionais

Requisito não funcional 1 – Especificação de projeto: além do código Java, deve ser produzida especificações de projeto baseada em UML;

Requisito não funcional 2 – Interface gráfica para usuário: o programa deverá ter interface gráfica única, compartilhada pelos usuários.

Requisito não funcional 3 – Localização das peças de cada jogador: A localização de cada peça no tabuleiro para cada jogador deve ficar visível na tela representadas por peças com cores diferentes (Azul e Vermelho).

Requisito não funcional 4 - Tecnologia de interface gráfica para usuário: A interface gráfica deve ser baseada em JavaSwing.

### Premissas de desenvolvimento

O programa deve apresentar uma interface gráfica bidimensional;
O programa deve ser implementado em Java, devendo executar em qualquer plataforma que disponha da máquina virtual Java;
Deve utilizar a ferramenta NetGamesNRT para fazer interação entre os usuários;
