# API Para Controle de Consultas da Clinica

## Instruções

### Requisitos
- Java 17
- Database: postgres
- Username: postgres
- Password: 12345

### Instalação
- Clone projeto
- Importe para a IDE (Eclipse, Intellij)
- Atualize as bibliotecas
- Inicie

### Acesso
- Por um gerenciador de APIs (Postman, Insomnia)

### Utilização

#### Especialidade
Cadastro de especialidade:
- URI: http://localhost:8080/especialidade/cadastrar
- Método: POST
- Fomulário JSON: id, nome.

Listar todos as especialidades:
- URI: http://localhost:8080/especialidade/listar
- Método: GET

Exibir especialidade:
- URI: http://localhost:8080/especialidade/id/{id}
- Método: GET

Excluir cadastro de especialidade:
- URI: http://localhost:8080/especialidade/excluir/{id}
- Método: DELETE

Alterar cadastro de uma especialidade:
- URI: http://localhost:8080/especialidade/alterar
- Método: PUT
- Fomulário JSON: id, nome.

#### Médicos
Cadastro de médico:
- URI: http://localhost:8080/medico/cadastrar
- Método: POST
- Fomulário JSON: id, nome, especialidade.

Listar todos os médicos:
- URI: http://localhost:8080/medico/listar
- Método: GET

Exibir médico:
- URI: http://localhost:8080/medico/id/{id}
- Método: GET

Excluir cadastro de médico:
- URI: http://localhost:8080/medico/excluir/{id}
- Método: DELETE

Alterar cadastro de um médico:
- URI: http://localhost:8080/medico/alterar
- Método: PUT
- Fomulário JSON: id, nome, especialidade.

#### Pacientes
Cadastro de paciente:
- URI: http://localhost:8080/paciente/cadastrar
- Método: POST
- Fomulário JSON: id, nome, cpf.

Listar todos os pacientes:
- URI: http://localhost:8080/paciente/listar
- Método: GET

Exibir paciente:
- URI: http://localhost:8080/paciente/id/{id}
- Método: GET

Excluir cadastro de paciente:
- URI: http://localhost:8080/paciente/excluir/{id}
- Método: DELETE

Alterar cadastro de um paciente:
- URI: http://localhost:8080/paciente/alterar
- Método: PUT
- Fomulário JSON: id, nome, cpf.

#### Consulta
Cadastro de consulta:
- URI: http://localhost:8080/consulta/cadastrar
- Método: POST
- Fomulário JSON: id, medico, paciente, dataConsulta.

Listar todos os pacientes:
- URI: http://localhost:8080/consulta/listar
- Método: GET

Exibir paciente:
- URI: http://localhost:8080/consulta/id/{id}
- Método: GET

Excluir cadastro de paciente:
- URI: http://localhost:8080/consulta/excluir/{id}
- Método: DELETE

Alterar cadastro de um paciente:
- URI: http://localhost:8080/consulta/alterar
- Método: PUT
- Fomulário JSON: id, medico, paciente, dataConsulta.