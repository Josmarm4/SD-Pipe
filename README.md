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


# SD-Pipe: Implementação do Padrão Produtor-Consumidor com Pipes

Este projeto implementa o padrão **Produtor-Consumidor com um filtro**, utilizando **pipes** para a comunicação entre threads em Java. O objetivo é explorar técnicas de sincronização e comunicação em um ambiente de programação concorrente.

---

## 💡 Descrição

O projeto utiliza as seguintes classes para ilustrar o funcionamento do padrão:

### **Classe `Produtor`**
- Gera valores `double` aleatórios (entre 0 e 1).
- Escreve os valores no fluxo de saída conectado ao pipe.
- Faz uma pausa de tempo aleatório (0 a 1 segundo) entre as gerações.

### **Classe `Filtro`**
- Atua como intermediário entre o produtor e o consumidor.
- Lê os valores do pipe de entrada e calcula uma média.
- Envia a média calculada para o pipe de saída conectado ao consumidor.

### **Classe `Consumidor`**
- Lê continuamente as médias do fluxo de entrada.
- Exibe no console a média atual processada.

### **Classe `PipeTest`**
- Configura a comunicação entre as threads `Produtor`, `Filtro` e `Consumidor`.
- Cria os pipes necessários para conectar as threads.
- Inicia a execução das threads.

---

## ⚙️ Execução

### 1. **Compilar o código**
Compile os arquivos Java utilizando o seguinte comando no terminal:

```bash
javac *.java
```

Isso irá compilar todas as classes no diretório.

### 2. **Executar o programa**
Para executar o programa, utilize:

```bash
java PipeTest | tee log_execucao_$(date +%F_%T).txt
```

O comando acima executará o programa e salvará os logs de saída no arquivo `log_execucao_<data_hora>.txt`.

---

## 🔄 Logs de Execução

Abaixo estão exemplos de logs gerados durante a execução do programa:

```
Current average is 0.3715257519087345
Current average is 0.4291857234545633
Current average is 0.46605135936431835
Current average is 0.5293315657737322
...
```

Os logs mostram as médias calculadas pelo Filtro e lidas pelo Consumidor.

---
