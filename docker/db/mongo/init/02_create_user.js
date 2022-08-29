// Define an application user.
let user = {
  user: 'appuser',
  pwd: 'appuser',
  roles: [{
    role: 'readWrite',
    db: 'poc'
  }]
};
// Execute mongodb command to create the above user.
db.createUser(user);