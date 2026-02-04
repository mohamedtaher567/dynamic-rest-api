Example PowerShell Command:

```
Invoke-RestMethod `
   -Uri "http://localhost:8080/admin/registerRoutes" `
   -Method POST `
   -ContentType "application/json" `
   -Body '{
     "servicePath": "C:\\Users\\me059960\\UserService.class",
     "routesDetails": [
       {
         "path": "/users",
         "method": "GET",
         "action": "getUsers"
       }
     ]
  }'
```
