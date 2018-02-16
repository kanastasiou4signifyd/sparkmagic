#!/bin/bash

sed -i s"/localhost/$LIVY_HOST/g" .sparkmagic/config.json 
start-notebook.sh --NotebookApp.iopub_data_rate_limit=1000000000 \
	--NotebookApp.open_browser=False \
	--NotebookApp.contents_manager_class='ipymd.IPymdContentsManager' \
	--NotebookApp.log_level='DEBUG' \
	--NotebookApp.notebook_dir=/home/jovyan/work