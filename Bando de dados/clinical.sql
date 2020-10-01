-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 01-Out-2020 às 02:22
-- Versão do servidor: 10.4.14-MariaDB
-- versão do PHP: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `clinical`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_agendamentos`
--

CREATE TABLE `tb_agendamentos` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `hora` varchar(8) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `id_medico` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_pacientes`
--

CREATE TABLE `tb_pacientes` (
  `id` int(11) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `dataNasc` varchar(10) NOT NULL,
  `rg` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tel` varchar(21) NOT NULL,
  `responsavel` varchar(80) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `num` int(11) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `estado` varchar(3) NOT NULL,
  `situacao` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_pacientes`
--

INSERT INTO `tb_pacientes` (`id`, `nome`, `cpf`, `dataNasc`, `rg`, `email`, `tel`, `responsavel`, `endereco`, `num`, `bairro`, `cidade`, `estado`, `situacao`) VALUES
(10001, 'gertrudes amorim do carmo', '00000100051', '2000-05-04', '541.658.555', 'gertrudesamorim@gmail.com', '(88)9 8842-0655', 'a mesma', 'rua dos periquitos', 34, 'funelandia', 'Juazeiro do Norte', 'CE', 'Ativo'),
(10002, 'patricio cambão', '111.111.111-52', '1981-02-02', '625.854.498', 'cambao@gmail.com', '(88) 9 8845-4748', 'o mesmo', 'presidente dultra', 25, 'triangulo', 'crato', 'CE', 'Ativo'),
(10003, 'fulano de tal', '000.000.000-12', '2021-09-20', '12345678', 'daksjdas@dksja.com', '(88) 9 8888-8888', 'beltrano', 'rua 2', 876, 'tewte', 'Barbalha', 'CE', 'Ativo'),
(10004, 'beltrano', '999.888.777-66', '24/09/2003', '2365432', 'beltrano@beltrano.com', '(88) 9 8877-6655', 'tetraciclano', 'rua 33', 65, 'centro', 'Juazeiro do Norte', 'CE', 'Ativo'),
(10005, 'antonio', '000.000.000-01', '23/09/1888', '6532675', 'ss@ss.com', '(99) 9 9999-9999', 'o mesmo', 'rua n', 987, 'centro', 'Crato', 'CE', 'Inativo'),
(10006, 'beltrano santos', '111.111.111-10', '31/12/1986', '21485754', 'beltranosantos@gmail.com', '(88) 9 8747-4747', 'maria de lourdes', 'rua n', 3214, 'centro', 'Barbalha', 'CE', 'Ativo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_usuarios`
--

CREATE TABLE `tb_usuarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `dataNasc` varchar(10) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(30) NOT NULL,
  `perfil` varchar(15) NOT NULL,
  `situacao` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_usuarios`
--

INSERT INTO `tb_usuarios` (`id`, `nome`, `cpf`, `tel`, `dataNasc`, `rg`, `email`, `senha`, `perfil`, `situacao`) VALUES
(1001, 'Jáder Oliveira', '620.998.923-34', '(88) 9 8842-0622', '24/09/1981', '2002029276028', 'jaderoliveiraa@gmail.com', '21548721', 'Suporte', 'Ativo'),
(1002, 'fulano de talllllllll', '888.888.888-88', '(88) 9 8888-8888', '20/09/2005', '2222144110', 'fulano@gmail.com', '123', 'Recepcionista', 'Ativo'),
(1003, 'Medico', '222.222.222-00', '(88) 8 8888-8844', '26/09/20', '3214578454', 'medico@medico.com', '123456', 'Médico', 'Ativo'),
(1004, 'brenner borges', '222.010.111-01', '(88) 9 5547-4747', '30/09/20  ', '20141547', 'brenner@gmail.com', '123456', 'Administrador', 'Ativo');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_agendamentos`
--
ALTER TABLE `tb_agendamentos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pacientes` (`id_paciente`),
  ADD KEY `fk_usuario` (`id_usuario`);

--
-- Índices para tabela `tb_pacientes`
--
ALTER TABLE `tb_pacientes`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_usuarios`
--
ALTER TABLE `tb_usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_agendamentos`
--
ALTER TABLE `tb_agendamentos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tb_pacientes`
--
ALTER TABLE `tb_pacientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10007;

--
-- AUTO_INCREMENT de tabela `tb_usuarios`
--
ALTER TABLE `tb_usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1005;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tb_agendamentos`
--
ALTER TABLE `tb_agendamentos`
  ADD CONSTRAINT `fk_medicos` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuarios` (`id`),
  ADD CONSTRAINT `fk_pacientes` FOREIGN KEY (`id_paciente`) REFERENCES `tb_pacientes` (`id`),
  ADD CONSTRAINT `fk_usuarios` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
