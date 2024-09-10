-- Criando dados de teste para a tabela tb_technician
INSERT INTO tb_technician (name, email, phone_number, password, cpf)
VALUES 
('John Doe', 'john.doe@example.com', '1234567890', 'password1', '11122233344'),
('Jane Smith', 'jane.smith@example.com', '0987654321', 'password2', '55566677788');

-- Criando dados de teste para a tabela tb_contract
INSERT INTO tb_contract (title, description, contract_value, privacy)
VALUES 
('Contract A', 'Description for contract A', 10000, 'PRIVATE'),
('Contract B', 'Description for contract B', 20000, 'PUBLIC');

-- Criando dados de teste para a tabela contract_editors
INSERT INTO contract_editors (contract_id, contract_editors)
VALUES
(1, 'john.doe@example.com'),
(1, 'jane.smith@example.com'),
(2, 'jane.smith@example.com');

-- Criando dados de teste para a tabela tb_client
INSERT INTO tb_client (name, document_number, password, contract_id)
VALUES 
('Client 1', '11122233344', 'clientpassword1', 1),
('Client 2', '55566677788', 'clientpassword2', 2);

-- Criando dados de teste para a tabela contract_technician (muitos para muitos)
INSERT INTO contract_technician (contract_id, technician_id)
VALUES
(1, 1),
(1, 2),
(2, 2);
