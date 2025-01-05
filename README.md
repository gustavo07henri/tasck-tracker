# Task Tracker CLI

Este é um programa de linha de comando (CLI) para gerenciar tarefas. Ele permite adicionar, atualizar, excluir e listar tarefas, bem como marcar tarefas com diferentes status.

## Funcionalidades

- Adicionar uma nova tarefa
- Atualizar uma tarefa existente
- Excluir uma tarefa
- Marcar uma tarefa como "To-Do"
- Marcar uma tarefa como "In-Progress"
- Marcar uma tarefa como "Done"
- Listar todas as tarefas
- Listar tarefas por status ("To-Do", "In-Progress", "Done")
- Sair do programa

## Como usar

1. Clone o repositório para sua máquina local.
   `https://github.com/gustavo07henri/tasck-tracker`
3. Abra o projeto na sua IDE preferida (como o IntelliJ IDEA, Eclipse ou VS Code).
4. Execute a classe `Main.java` para iniciar o programa.


## Comandos

- `add [description]` : Adicionar uma nova tarefa com a descrição fornecida.
- `update [id] [description]` : Atualizar a descrição de uma tarefa existente com o ID fornecido.
- `delete [id]` : Excluir uma tarefa com o ID fornecido.
- `mark-todo [id]` : Marcar uma tarefa como "To-Do" com o ID fornecido.
- `mark-in-progress [id]` : Marcar uma tarefa como "In-Progress" com o ID fornecido.
- `mark-done [id]` : Marcar uma tarefa como "Done" com o ID fornecido.
- `list` : Listar todas as tarefas.
- `list-todo` : Listar todas as tarefas com status "To-Do".
- `list-in-progress` : Listar todas as tarefas com status "In-Progress".
- `list-done` : Listar todas as tarefas com status "Done".
- `exit` : Sair do programa.

## Exemplo de Uso

```sh
java Cli
