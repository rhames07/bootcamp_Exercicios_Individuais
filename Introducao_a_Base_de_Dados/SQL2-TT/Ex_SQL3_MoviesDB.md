# Exercício - SQL3 Movies DB

## 1 - Explique o conceito de normalização e para que é usado.
> É o processo de estruturação de uma base de dados que tem como objetivo reduzir a redundância e aumentar a integridade dos dados.
## 2 - Adicione um filme à tabela de filmes.
```sql
INSERT INTO movies (title, rating, awards, release_date) VALUES ('Rua do Medo: 1666 - Parte 3', '9.5', '3', '2021-07-16');
```
## 3 - Adicione um gênero à tabela de gêneros.
```sql
INSERT INTO genres (created_at, name, ranking, active) VALUES ('2021-07-20','Comedia Romantica', 13, 1);
```
## 4 - Associe o filme do Ex 2. ao gênero criado no Ex. 3.
```sql
UPDATE movies m SET genre_id=15 WHERE m.id=22;
```
## 5 - Modifique a tabela de atores para que pelo menos um ator adicione como favorito o filme adicionado no Ex. 2.
```sql
UPDATE actors a SET favorite_movie_id=22 WHERE a.id=3;
```
## 6 - Crie uma cópia temporária da tabela de filmes.
```sql
CREATE TEMPORARY TABLE temp_movies AS (SELECT * FROM movies);
```
## 7 - Elimine desta tabela temporária todos os filmes que ganharam menos de 5 prêmios.
```sql
DELETE FROM temp_movies WHERE awards < 5;
```
## 8 - Obtenha a lista de todos os gêneros que possuem pelo menos um filme.
```sql
SELECT DISTINCT g.name FROM genres g INNER JOIN movies m ON (m.genre_id=g.id);
```
## 9 - Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.
```sql
SELECT a.first_name, a.last_name FROM actors a INNER JOIN movies m ON (a.favorite_movie_id=m.id) WHERE m.awards > 3;
```
## 10 - Use o plano de explicação para analisar as consultas nos Ex. 6 e 7.
```sql
EXPLAIN SELECT * FROM temp_movies;
```
------------------------------------------------------------------------------------------------------------------------
| id | select_type | table       | partitions | type | possible_keys | key  | key_len | ref  | rows | filtered | Extra |
|----|-------------|-------------|------------|------|---------------|------|---------|------|------|----------|-------|
|  1 | SIMPLE      | temp_movies | NULL       | ALL  | NULL          | NULL | NULL    | NULL |   22 |   100.00 | NULL  |
------------------------------------------------------------------------------------------------------------------------
1 row in set, 1 warning (0.00 sec)
```sql
EXPLAIN DELETE FROM temp_movies WHERE awards < 5;
```
------------------------------------------------------------------------------------------------------------------------------
| id | select_type | table       | partitions | type | possible_keys | key  | key_len | ref  | rows | filtered | Extra       |
|----|-------------|-------------|------------|------|---------------|------|---------|------|------|----------|-------------|
|  1 | DELETE      | temp_movies | NULL       | ALL  | NULL          | NULL | NULL    | NULL |   22 |   100.00 | Using where |
------------------------------------------------------------------------------------------------------------------------------
1 row in set (0.00 sec)

## 11 - O que são os índices? Para que servem?
> É uma forma de otimizar as consultas em SQL para melhorem acesso aos dados.
## 12 - Crie um índice sobre o nome na tabela de filmes.
```sql
CREATE INDEX idx_movie_title ON movies (title);
```
## 13 - Verifique se o índice foi criado corretamente.
```sql
SHOW INDEX FROM movies;
```
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
| Table  | Non_unique | Key_name                | Seq_in_index | Column_name | Collation | Cardinality | Sub_part | Packed | Null | Index_type | Comment | Index_comment |
|--------|------------|-------------------------|--------------|-------------|-----------|-------------|----------|--------|------|------------|---------|---------------|
| movies |          0 | PRIMARY                 |            1 | id          | A         |          21 |     NULL | NULL   |      | BTREE      |         |               |
| movies |          1 | movies_genre_id_foreign |            1 | genre_id    | A         |           8 |     NULL | NULL   | YES  | BTREE      |         |               |
| movies |          1 | idx_movie_title         |            1 | title       | A         |          22 |     NULL | NULL   |      | BTREE      |         |               |
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3 rows in set (0.00 sec)