# Spring-Cloud GraphQL demo
## 1. Install & init database
```
docker-compose up -d
```
## 2. Set up applications
In this demo, there are 4 applications. Here is description of them.

| application name  | port | description             |
|-------------------|------|-------------------------|
| eureka-server     | 8761 | service register center |
| gql-demo          | 8769 | api composer            |
| ticket-server     | 8763 | ticket service provider |
| user-server       | 8762 | user service provider   |

## 3. Getting Started
After run up these application. You can visit 
```http://localhost:8769/graphiql```
and input queries.
```
query selectUserById($id: ID!) {
  selectUserById (id: $id) {
    id
    name
    mail
  }
}

query allUsers {
  allUsers {
    id
    name
    mail
  }
}

query selectTicketById($id: ID!) {
  selectTicketById(id: $id) {
    id
    title
    createdBy
    user {
      id
      name
      mail
    }
    deleted
  }
}

query getAllTicket {
  getAllTicket{
    id
    title
    createdBy
    deleted
   user {
      id
      name
      mail
    }
  }
}

mutation addUser($user: UserInput!){
  addUser(user: $user) {
    name
    mail
    id
  }
}
```
