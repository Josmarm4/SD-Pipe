# Comunicação entre processo: Pipes - canais de comunicação locais

Este projeto implementa um padrão produtor-consumidor com um filtro, utilizando pipes para comunicação entre threads. 

![image](https://github.com/user-attachments/assets/d31ecf2f-2784-4b23-a964-49388a461b08)

## Classe Produtor:
* Gera continuamente valores double aleatórios entre 0 e 1 usando rand.nextDouble().
* Em seguida, escreve o double gerado no fluxo de saída out, que é um DataOutputStream conectado a um pipe.
* O produtor dorme por um tempo aleatório entre 0 e 1 segundo usando sleep(Math.abs(rand.nextInt() % 1000)).
* Trata quaisquer exceções que possam ocorrer durante a escrita no fluxo.

## Classe Consumidor:
* Lê continuamente doubles do fluxo de entrada in, que é um DataInputStream conectado a um pipe.
* O double lido é assumido como um valor médio.
* Imprime a média atual no console e armazena-a na variável old_avg.
* Trata quaisquer exceções que possam ocorrer durante a leitura do fluxo.

## Classe Filtro:
* Atua como um filtro entre o produtor e o consumidor.
* Lê doubles do fluxo de entrada in, que está conectado ao pipe de saída do produtor.
* Mantém o controle da soma total e do número de valores lidos usando as variáveis total e count.
* Quando um valor é lido, calcula a média dividindo total por count.
* Se houver valores lidos (count não é zero), escreve a média calculada no fluxo de saída out, que está conectado ao pipe de entrada do consumidor.
* Trata quaisquer exceções que possam ocorrer durante a leitura ou escrita nos fluxos.

## Classe PipeTest:
* É o ponto de entrada principal e configura a comunicação entre o produtor, o filtro e o consumidor.
* Cria dois pares de pipes: pout1 e pin1 para o produtor e o filtro, e pout2 e pin2 para o filtro e o consumidor.
* Em seguida, cria instâncias das classes Producer, Filter e Consumer, passando os pipes apropriados para cada uma.
* Finalmente, inicia todas as threads, permitindo que o produtor gere valores, o filtro calcule a média e o consumidor leia e exiba a média.

# Atividade Prática:
* Crie seu Repositório no github em seu perfil para incluir os programas;
* Compile e Executes os programas com log de execução com data e hora de execução;
* Realize o upload dos prints no seu repositório;
* Envie o link do seu repositório do github como resposta da atividade;


