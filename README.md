# 🧪 Projeto de Testes Automatizados com Selenium

Projeto de automação de testes para um sistema de controle de produtos, desenvolvido com Java, Selenium WebDriver e JUnit 5, utilizando o padrão Page Object Model (POM).

## 📋 Sobre o Projeto

Este projeto implementa testes automatizados end-to-end para validar funcionalidades de um sistema web de controle de produtos, incluindo autenticação de usuários e operações CRUD de produtos.

## 🚀 Tecnologias Utilizadas

- **Java** - Linguagem de programação
- **Selenium WebDriver** - Framework para automação de navegadores
- **JUnit 5** - Framework de testes unitários
- **Maven** - Gerenciamento de dependências
- **Page Object Model (POM)** - Padrão de design para organização dos testes
- **Builder Pattern** - Padrão de projeto para construção de objetos de teste

## 📁 Estrutura do Projeto

```
src/
├── main/java/br/com/teste/auttomatizados/
│   ├── build/
│   │   └── ProdutoBuilder.java          # Builder para criação de produtos
│   └── page/
│       ├── BasePO.java                   # Classe base para Page Objects
│       ├── LoginPO.java                  # Page Object da tela de login
│       ├── ControleDeProdutoPO.java      # Page Object da tela de produtos
│       └── GooglePO.java                 # Page Object do Google (exemplo)
└── test/java/br/com/teste/auttomatizados/test/
    ├── BaseTest.java                     # Classe base para testes
    ├── LoginTest.java                    # Testes de login
    ├── ConrolesDeProdutoTest.java        # Testes de produtos
    └── GoogleTest.java                   # Testes de exemplo
```

## 🔧 Configuração do Ambiente

### Pré-requisitos

- Java JDK 11 ou superior
- Maven 3.6 ou superior
- Chrome/ChromeDriver compatível
- Servidor local rodando na porta 5500

### Instalação

1. Clone o repositório:
```bash
git clone <url-do-repositorio>
cd projeto-testes-automatizados
```

2. Instale as dependências:
```bash
mvn clean install
```

3. Configure o servidor local:
   - O projeto está configurado para acessar `http://127.0.0.1:5500/login.html`
   - Certifique-se de que os arquivos HTML estão sendo servidos neste endereço

## ▶️ Executando os Testes

### Executar todos os testes:
```bash
mvn test
```

### Executar uma classe específica:
```bash
mvn test -Dtest=LoginTest
```

### Executar um teste específico:
```bash
mvn test -Dtest=LoginTest#TC001_naoDeveLogarNoSistemaComEmailESenhaVazios
```

## 📝 Casos de Teste

### Login (LoginTest.java)
- `TC001` - Validar login com email e senha vazios
- `TC002` - Validar login com email incorreto e senha vazia
- `TC003` - Validar login com email vazio e senha incorreta
- `TC004` - Validar login com credenciais corretas

### Controle de Produtos (ConrolesDeProdutoTest.java)
- `TC001` - Validar abertura do modal de cadastro
- `TC003` - Validar cadastro de produto sem preencher campos obrigatórios

## 🎯 Padrões Utilizados

### Page Object Model (POM)
Cada página da aplicação possui uma classe correspondente que encapsula os elementos e ações dessa página, promovendo reusabilidade e manutenibilidade.

### Builder Pattern
Utilizado para construção flexível de objetos de produto nos testes, permitindo criar diferentes cenários de teste de forma fluente:

```java
ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);
produtoBuilder
    .adicionarCodigo("001")
    .adicionarNome("Produto Teste")
    .adicionarQuantidade(10)
    .adicionarValor(99.90)
    .adicionarData("09/12/2025")
    .builder();
```

## 🔐 Credenciais de Teste

**Usuário padrão:**
- Email: `admin@admin.com`
- Senha: `admin@123`

## 🛠️ Funcionalidades Implementadas

### BasePO
- Inicialização automática de elementos com PageFactory
- Método genérico para escrita em campos de input
- Obtenção de título da página

### ProdutoBuilder
- Construção flexível de produtos para testes
- Valores padrão configuráveis
- Interface fluente para encadeamento de métodos

### Configurações do Chrome
- Modo maximizado
- Desabilitação de features de automação para evitar detecção

## 📊 Relatórios

Os resultados dos testes são exibidos no console durante a execução. Para gerar relatórios mais detalhados, considere integrar ferramentas como:
- Allure Reports
- ExtentReports
- Surefire Reports (Maven)

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/NovaFuncionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/NovaFuncionalidade`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 👥 Autores

Projeto desenvolvido para fins educacionais e demonstração de boas práticas em automação de testes.

---

**Nota:** Este é um projeto de exemplo para demonstração de testes automatizados. Ajuste as configurações conforme necessário para seu ambiente.
