# Spinning up a mongodb helm Chart with default configuration(server on port 27017, and super user root with random generated password)

1. Install mongodb by running the following command(assuming you have an empty mongodb-test project/namespace):

```bash
helm install my-mongodb bitnami/mongodb -n mongodb-test
```

2. After deployment of chart finished, run the following command to the the password of root:
```shell
export MONGODB_ROOT_PASSWORD=$(oc get secret --namespace mongodb-test my-mongodb -o jsonpath="{.data.mongodb-root-password}" | base64 --decode)
``` 

3. Then connect to the mongodb pod , and connect there to the DB:
```shell
 oc run --namespace mongodb-test my-mongodb-client --rm --tty -i --restart='Never' --env="MONGODB_ROOT_PASSWORD=$MONGODB_ROOT_PASSWORD" --image docker.io/bitnami/mongodb:5.0.9-debian-10-r0 --command -- bash

 mongosh admin --host "my-mongodb" --authenticationDatabase admin -u root -p $MONGODB_ROOT_PASSWORD
```

4. Create A Database inside mongodb server(after connected to mongo as root user):
```shell
sampledb> show databases
admin     100.00 KiB
config     72.00 KiB
itemsDEV   72.00 KiB
local      72.00 KiB
sampledb   40.00 KiB
sampledb> use demo-db
switched to db demo-db
demo-db> db.user.insertOne({name: "John Doe", profession: "Teacher"})
{
  acknowledged: true,
  insertedId: ObjectId("62bc6b828676381d5ba46440")
}

demo-db> show databases
admin     100.00 KiB
config     72.00 KiB
demo-db    40.00 KiB
itemsDEV   72.00 KiB
local      72.00 KiB
sampledb   40.00 KiB

```


5. Forward port 27017 to client machine if needed to use the mognodb for testing purposes and debugging locally:
```shell
oc port-forward --namespace mongodb-test svc/my-mongodb 27017:27017 ; mongosh --host 127.0.0.1 --authenticationDatabase admin -p $MONGODB_ROOT_PASSWORD
```


