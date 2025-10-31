#!/bin/bash
set -e

# Lista de bancos separados por vírgula
for db in revenda_db pagamento_db; do
    echo "Criando banco de dados: $db"
    psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
        CREATE DATABASE $db;
    EOSQL
done

