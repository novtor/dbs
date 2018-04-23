echo " "
echo " ### Starting replica set cluster..."

echo " "
echo " ### Starting replica set: rs1"
cd rs1
../../bin/mongod --config mongodb.conf --fork

echo " "
echo " ### Starting replica set: rs2"
cd ../rs2
../../bin/mongod --config mongodb.conf --fork

echo " "
echo " ### Starting replica set: rs3"
cd ../rs3
../../bin/mongod --config mongodb.conf --fork

echo " type in mongoshell rs.initiate({"_id":"rs", "members":[{"_id": 0, "host": "localhost:27017"}, {"_id":1, "host":"localhost:27018"},{"_id":2, "host": "localhost:27019"}]})"
