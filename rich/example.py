#!/usr/bin/env python3
# -*- coding:utf-8 -*-

# #############################################################################
# File Name   : example.py
# Author      : DaiDai
# Mail        : daidai4269@aliyun.com
# Created Time: 日  5/ 2 14:08:01 2021
# #############################################################################

# Print
from rich import print
print("Hello, [bold magenta]World[/bold magenta]!", ":vampire:", locals())

# REPL
from rich import pretty
pretty.install()
print([False, True, None, 3.14, "Hello World! " * 5, {"foo": "bar"}])
# Console
from rich.console import Console

console = Console()
console.print("Hello", "World!")
console.print("Hello", "World!", style="bold red")
console.print("Where there is a [bold cyan]Will[/bold cyan] there [u]is[/u] a [i]way[/i].")
# Inspect

my_list = ["foo", "bar"]
from rich import inspect
inspect(my_list, methods=True)
# tables

from rich.console import Console
from rich.table import Table

console = Console()

table = Table(show_header=True, header_style="bold magenta")
table.add_column("Date", style="dim", width=12)
table.add_column("Title")
table.add_column("Production Budget", justify="right")
table.add_column("Box Office", justify="right")
table.add_row(
    "Dev 20, 2019", "Star Wars: The Rise of Skywalker", "$275,000,000", "$375,126,118"
)
table.add_row(
    "May 25, 2018",
    "[red]Solo[/red]: A Star Wars Story",
    "$275,000,000",
    "$393,151,347",
)
table.add_row(
    "Dec 15, 2017",
    "Star Wars Ep. VIII: The Last Jedi",
    "$262,000,000",
    "[bold]$1,332,539,889[/bold]",
)

console.print(table)
# tree
import os
os.system("python3 -m rich.tree")

# markdown

from rich.console import Console
from rich.markdown import Markdown

console = Console()
with open("README.md") as readme:
    markdown = Markdown(readme.read())
console.print(markdown)
