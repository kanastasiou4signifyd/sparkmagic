---
kernelspec:
  display_name: Spark
  language: ''
  name: sparkkernel
language_info:
  codemirror_mode: text/x-scala
  mimetype: text/x-scala
  name: scala
  pygments_lexer: scala
---

```python
>>> %%help
```

```python
>>> %%info
<IPython.core.display.HTML object>
<IPython.core.display.HTML object>
```

```python
>>> %%sql
... select * from junk
The code failed because of a fatal error:
	Session 1 did not start up in 60 seconds..

Some things to try:
a) Make sure Spark has enough available resources for Jupyter to create a Spark context.
b) Contact your Jupyter administrator to make sure the Spark magics library is configured correctly.
c) Restart the kernel.
```

```python
>>> %%local
... import pandas as pd
... pd
<module 'pandas' from '/opt/conda/lib/python3.6/site-packages/pandas/__init__.py'>
```
