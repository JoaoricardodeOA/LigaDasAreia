# LigaDasAreia
Um jogo que possui ranking, pode ser adicionado novos jogadores e pode modifica- los, além da própria execução do jogo.

O trabalho foi feito com a separação de partes para os membros do grupo, sendo elas:
João Ricardo e Luiz Eduardo ficaram responsaveis pela interface de login, senha, criação de conta no jogo e o ranking colocando em pratica o que foi ensinado em aula
Hugo Leonardo e João Gabriel ficaram responsaveis pela estrutura do jogo e jogabilidade


Foram usados alguns project patterns, entre eles: Facade para controle de Interface, Singleton para somente existir uma instância do Facade e da lista de ranking e Strategy foi usado criando uma classe abstrata para personagem, podendo ser guerreiro ou vilão(CPU). Além de tudo isso foi usado um MVC para organização das classes em Controller, Entities, View e Exceptions.

Em relação ao SOLID, foi usado o S para organização das responsabilidades das classes, o O foi usado para cada classe ter autonomia em relação aos seus objetos, o L para a abstração da classe Character, o I para criar somente metodos e abstrações necessárias, e D foi usado para as classes só dependerem das abstrações. 
