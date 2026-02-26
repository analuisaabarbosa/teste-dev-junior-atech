# Lotação Máxima de Sala de Espera

## Contexto do Problema

Foi solicitada uma avaliação da capacidade necessária de um aeroporto para atender passageiros em salas de espera. O objetivo é identificar qual foi a **lotação máxima simultânea** de uma sala, dado o horário de entrada e saída de cada passageiro.

Os dados já foram pré-processados pela equipe técnica: os horários de entrada e saída de cada passageiro foram transformados em números inteiros entre **1 e 1000**.

---

## O Problema

Dado um número `N` de passageiros (1 ≤ N ≤ 100), uma lista `E` com os momentos de entrada e uma lista `S` com os momentos de saída, devo determinar qual foi o maior número de passageiros simultaneamente presentes na sala.

> **Regra de simultaneidade:** se um passageiro sai no instante `X` e outro entra no instante `X`, esse instante é contabilizado como apenas 1 pessoa.

### Exemplos

**Exemplo 1:** N = 3, E = [1, 5, 7], S = [9, 13, 12] → **Resposta: 3**
Entre os instantes 7 e 8, os 3 passageiros estavam simultaneamente na sala.

**Exemplo 2:** N = 4, E = [1, 4, 8, 10], S = [3, 8, 10, 17] → **Resposta: 1**
Em nenhum momento houve mais de 1 passageiro simultaneamente na sala.

## Explicação Técnica

O algoritmo que estruturei utiliza uma abordagem de linha do tempo baseada em array para determinar a lotação máxima simultânea da sala de espera.

Aloquei um array `timeline` de tamanho 1001, onde cada índice representa um instante de tempo entre 1 e 1000. Para cada passageiro `i`, o algoritmo percorre o intervalo `[entries[i], exits[i])`, limite superior exclusivo, e incrementa em 1 o valor de cada posição percorrida. Ao final desse processo, cada índice do array contém o número de passageiros presentes naquele instante. Uma segunda iteração sobre o array identifica o valor máximo, que é retornado como resposta.

Minha decisão de usar o intervalo com limite superior exclusivo resolve diretamente a regra de simultaneidade do enunciado, se um passageiro sai no instante `X` e outro entra no instante `X`, o índice `X` registra apenas a nova entrada, refletindo corretamente a lotação física de 1 pessoa naquele momento.

Utilizei a abordagem por vetor de tempo conscientemente em detrimento de soluções baseadas em ordenação de eventos, que teriam complexidade O(N log N). Como o domínio do problema é fixo e limitado, os instantes de tempo estão restritos ao intervalo [1, 1000], o custo de iterar sobre o vetor é constante e previsível, tornando a solução mais simples, direta e igualmente eficiente para este contexto específico.

**Complexidade:** O(n × t) no tempo, onde `n` é o número de passageiros e `t` o tamanho do intervalo de permanência; O(t) no espaço adicional, dado que o array tem tamanho fixo determinado pelo domínio do problema.

---

## Explicação para Equipe de Negócios

Para descobrir qual foi o maior número de passageiros presentes ao mesmo tempo na sala, criei uma espécie de linha do tempo que vai do instante 1 até o instante 1000.

Para cada passageiro, marquei na linha do tempo todos os momentos em que ele esteve dentro da sala, do momento em que entrou até o momento imediatamente anterior ao que saiu. Isso garante que, se uma pessoa saiu e outra entrou ao mesmo tempo, esse instante seja contado como apenas 1 pessoa, o que reflete o que realmente acontece na sala.

Essa abordagem foi escolhida pela sua simplicidade e adequação ao problema, como os horários já foram transformados em números entre 1 e 1000, a linha do tempo tem sempre o mesmo tamanho fixo, o que torna o processamento rápido e previsível, sem a necessidade de técnicas mais complexas que seriam necessárias caso os dados fossem maiores ou mais variados.

Depois de marcar todos os passageiros, basta olhar para a linha do tempo e encontrar o instante com o maior número de marcações. Esse número é a lotação máxima da sala no período analisado.

## Como executar

```bash
java src/AirportSolution.java
```

**Entrada de teste:**

```
3
1 5 7
9 13 12
```

**Saída:**

```
3
```
