# Sistema de Gerenciamento de Eventos - Menu Interativo

Este sistema interativo de gerenciamento de eventos permite que os usuários realizem várias tarefas, como comprar ingressos, cadastrar eventos e gerenciar eventos por meio de um menu simples. O menu oferece opções para comprar ingressos, cadastrar novos eventos, salvar eventos em um arquivo CSV e ler eventos de um arquivo CSV.

## Como Usar o Menu

### Opções do Menu Principal:

Ao executar o programa, o menu principal será exibido com as seguintes opções:

- **a) Comprar ingresso**
- **b) Cadastrar evento**
- **c) Salvar eventos em CSV**
- **d) Ler arquivo csv**
- **x) Sair**

### Guia Passo a Passo

1. **Comprar ingresso (a)**:  
   - Esta opção permite que você compre ingressos para um evento cadastrado.
   - Se nenhum evento estiver cadastrado, o programa informará e encerrará.
   - Você será apresentado com duas sub-opções:
     - **a) Pesquisar evento por nome**: Você digitará o nome do evento, e se o evento for encontrado, os detalhes serão exibidos, junto com a disponibilidade de ingressos nas diferentes áreas (VIP, Camarote, Pista). Você poderá então decidir se quer comprar o ingresso.(O nome digitado tem que ser exatamente igual ao nome do evento para ser encontrando, se não for igual ele não irá achar o Evento desejado).
     - **b) Listar eventos**: Exibe uma lista de todos os eventos cadastrados com a quantidade de ingressos disponíveis para cada área.
   - Após selecionar um evento e ver os detalhes dos ingressos, você pode escolher comprar o ingresso especificando a área (VIP, Camarote ou Pista).

2. **Cadastrar evento (b)**:  
   - Use esta opção para registrar um novo evento.
   - Você será solicitado a fornecer os seguintes detalhes:
     - Nome do evento
     - Local
     - Data
     - Capacidade máxima
     - Preços e quantidades de ingressos para as áreas VIP, Camarote e Pista.
   - Após fornecer todos os detalhes, o evento será cadastrado e estará disponível para a compra de ingressos.
   - So é possivel adicionar no máximo 10 eventos.
    
3. **Salvar eventos em CSV (c)**:  
   - Esta opção salva todos os eventos cadastrados em um arquivo CSV.
   - Se não houver eventos cadastrados, o programa informará que não há eventos para salvar.

4. **Ler arquivo csv (d)**:  
   - Esta opção lê e exibe os eventos armazenados em um arquivo CSV.

5. **Sair (x)**:  
   - Use esta opção para sair do programa.

### Notas Adicionais:
- O programa realiza várias validações, como garantir que os eventos estejam cadastrados antes de permitir a compra de ingressos ou o salvamento de eventos.
- O processo de compra de ingressos inclui verificar a disponibilidade na área selecionada (VIP, Camarote ou Pista) antes de permitir que o usuário complete a compra.
- Se quiser ler um arquivo csv, de fora mudar o caminho ou colocar o mesmo nome do caminho da classe do csv
