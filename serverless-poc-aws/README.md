# serverless-poc-aws
Project to POC serverless architecture.

We have created a lambda function for file upload use case.

### Serverless:

We have created a serverless template to run the lambda function locally. We need to configure Serverless CLI.

##### To Install Serverless CLI:

```shell
curl -o- -L https://slss.io/install | bash
```

##### To Run the application  locally:

First make sure the `mongodb` container is running by executing `docker compose up -d`.

Then run the following:

```shell
serverless invoke local --function fileUpload --path example-data.json
```

Or instead of using a file as input, you can use the `--data` option as follow:

```shell
serverless invoke local --function fileUpload --data '{"fileName": "my-file.txt", "fileContent": "someData"}'
```

This will run the function with the local environment, to run it in docker just add `--docker` option.

All functions:

1. Upload a file:

```shell
serverless invoke local --function uploadFile --path example-data.json
```

2. Retrieve all files:

```shell
serverless invoke local --function retrieveAllFiles
```

3. Retrieve one file by ID:

```shell
serverless invoke local --function retrieveFileById --data '{"id": "c034c4f1-0e7a-4b5b-be59-e3d7b4769d91"}'
```

5. Delete a file:

```shell
serverless invoke local --function deleteFileById --data '{"id": "c034c4f1-0e7a-4b5b-be59-e3d7b4769d91"}'
```