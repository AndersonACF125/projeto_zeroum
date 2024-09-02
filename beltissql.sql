-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 02/09/2024 às 21:19
-- Versão do servidor: 10.1.36-MariaDB
-- Versão do PHP: 7.0.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `beltis`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `project`
--

CREATE TABLE `project` (
  `id` bigint(20) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `descricao` text,
  `data_inicio` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `project`
--

INSERT INTO `project` (`id`, `titulo`, `descricao`, `data_inicio`) VALUES
(1, 'Projeto A', 'Descrição do Projeto A', '2024-08-01'),
(2, 'Projeto B', 'Descrição do Projeto B', '2024-08-15'),
(3, 'Projeto C', 'Descrição do Projeto C', '2024-08-30'),
(4, 'ertet', 'erterte', '2024-09-03');

-- --------------------------------------------------------

--
-- Estrutura para tabela `task`
--

CREATE TABLE `task` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `estimativa_horas` double NOT NULL,
  `prioridade` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `task`
--

INSERT INTO `task` (`id`, `description`, `name`, `descricao`, `estimativa_horas`, `prioridade`, `titulo`) VALUES
(1, NULL, NULL, 'werwer', 343, 'Muito Alta', 'dwerw'),
(2, NULL, NULL, 'teste', 35, 'Alta', 'teste'),
(3, NULL, NULL, 'erererer', 34, 'Muito Alta', 'teete'),
(4, NULL, NULL, 'fazendo um teste simples', 23, 'Muito Alta', 'fazendo um teste simples');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `project`
--
ALTER TABLE `project`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `task`
--
ALTER TABLE `task`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
