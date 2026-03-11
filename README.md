# CashFlowControl

Aplicação para controle de fluxo de caixa pessoal e para profissionais autônomos.

## Objetivo do projeto
Construir uma solução com:
- **Backend** em Java + Spring Boot.
- **Frontend web** em React + Vite.
- **Banco de dados** PostgreSQL.
- **APIs versionadas** desde o início para facilitar futura integração com app mobile (Kotlin/XML).

## Escopo MVP (fase inicial)
Funcionalidades obrigatórias definidas:
1. CRUD de **receitas**.
2. CRUD de **despesas**.
3. **Recorrência** de lançamentos com frequências:
   - diária,
   - semanal,
   - mensal,
   - anual.
4. Dashboard simples com gráfico de **pizza por categoria**.
5. Exportação de relatórios em **PDF** e **Excel**.

## Decisões funcionais já alinhadas
- Aplicação será **multiusuário**.
- Recuperação de senha é necessária.
- Controle financeiro inicial será por **categoria**.
- Filtros prioritários do dashboard:
  - período,
  - categoria,
  - tipo (receita/despesa).
- Em recorrências, cada item deve permitir definir **data de vencimento**.
- Edição de recorrência na fase atual será tratada de forma **individual por ocorrência**.

## Arquitetura proposta

### Backend (Spring Boot)
- API REST em `/api/v1`.
- Estrutura sugerida de módulos:
  - `auth` (login, recuperação de senha),
  - `users`,
  - `categories`,
  - `transactions` (receitas/despesas),
  - `recurrences`,
  - `reports`,
  - `dashboard`.
- Padrão de resposta de erro recomendado:

```json
{
  "code": "VALIDATION_ERROR",
  "message": "Dados inválidos",
  "details": ["field=value inválido"]
}
```

### Frontend (React + Vite)
- Telas MVP:
  - Login,
  - recuperação de senha,
  - dashboard,
  - listagem e formulário de receitas,
  - listagem e formulário de despesas,
  - gestão de categorias,
  - exportação de relatórios.

### Banco de dados (PostgreSQL)
Entidades iniciais recomendadas:
- `users`
- `categories`
- `transactions`
- `recurrences`
- `password_reset_tokens`

## Modelo mínimo de dados (referência)

### users
- `id`
- `name`
- `email` (único)
- `password_hash`
- `created_at`
- `updated_at`

### categories
- `id`
- `user_id`
- `name`
- `type` (`INCOME`, `EXPENSE`, `BOTH`)
- `color`

### transactions
- `id`
- `user_id`
- `category_id`
- `type` (`INCOME`, `EXPENSE`)
- `description`
- `amount`
- `due_date`
- `paid_at` (opcional)
- `recurrence_id` (opcional)
- `created_at`
- `updated_at`

### recurrences
- `id`
- `user_id`
- `start_date`
- `frequency` (`DAILY`, `WEEKLY`, `MONTHLY`, `YEARLY`)
- `interval_value` (ex.: a cada 1 mês, a cada 2 semanas)
- `due_day` (apoio para vencimento em recorrências mensais)
- `active`

### password_reset_tokens
- `id`
- `user_id`
- `token`
- `expires_at`
- `used_at`

## Endpoints REST v1 sugeridos

### Autenticação e conta
- `POST /api/v1/auth/login`
- `POST /api/v1/auth/forgot-password`
- `POST /api/v1/auth/reset-password`

### Categorias
- `GET /api/v1/categories`
- `POST /api/v1/categories`
- `PUT /api/v1/categories/{id}`
- `DELETE /api/v1/categories/{id}`

### Lançamentos (receitas/despesas)
- `GET /api/v1/transactions`
- `POST /api/v1/transactions`
- `GET /api/v1/transactions/{id}`
- `PUT /api/v1/transactions/{id}`
- `DELETE /api/v1/transactions/{id}`

Filtros esperados no `GET /transactions`:
- `from` e `to` (período)
- `categoryId`
- `type`
- `page`, `size`, `sort`

### Dashboard
- `GET /api/v1/dashboard/summary?from=...&to=...`
- `GET /api/v1/dashboard/expense-by-category?from=...&to=...`

### Relatórios
- `GET /api/v1/reports/transactions.pdf?from=...&to=...`
- `GET /api/v1/reports/transactions.xlsx?from=...&to=...`

## Roadmap de implementação

### Fase 1 (MVP)
- Estruturar entidades de usuário, categoria, transação e recorrência.
- Implementar CRUD de categorias e transações.
- Implementar geração de ocorrências recorrentes.
- Implementar dashboard básico (pizza por categoria).
- Implementar exportação PDF/Excel.

### Fase 2
- Melhorias de UX e regras avançadas de recorrência.
- Evolução de segurança/autenticação.
- Preparação de sincronização para app mobile.

## Deploy recomendado (início simples)
- **Backend**: Render ou Railway.
- **Frontend**: Vercel ou Netlify.
- **Banco**: PostgreSQL gerenciado (Neon/Supabase/Railway).

Sem CI/CD obrigatório nesta etapa; pode ser adicionado posteriormente.
