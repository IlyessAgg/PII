# SQL to NoSQL migration
> Transfer your data from SQL to MongoDB.

![server](./source/undraw_server_status_5pbv.png)

## Objective
This project aims at helping research in the automation of the migration of a relational database to NoSQL. The importation of the initial schema to [Modelio](https://www.modelio.org/) will allow for modifications at will. The schema is then exported into an XMI that will be read and used to supervise the exportation of the data to JSON files which will be imported to [MongoDB](https://www.mongodb.com/).


## Progress
Done :
- Extraction into Java clases
- Modelio import
- XMI reading
- JSON creation and import

To Do :
- Extract the metadata
- Improve JSON creation (storing rows into a single JSONArray is not a good solution)
- Fetch foreign keys

## Issues
