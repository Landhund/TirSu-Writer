# TirSu-Writer

An attempt to write a PowerShell Script that creates Tir'su-Symbols for the [Gith Language](https://forgottenrealms.fandom.com/wiki/Gith_language) of the [Forgotten Realms](https://forgottenrealms.fandom.com/wiki/Forgotten_Realms) as SVG files.

Does it work yet? **Nope, not at all**, it barely even creates a valid SVG as an XML-Object. But I've just started, so there's still a lot to be done.

## Why PowerShell of all things?

Simple: I think I have the best chances of actually getting it to work in PS. Since a SVG is nothing more than a special case of an XML-File, juggling the structure is rather straight forward in PS. And since I have to work with PowerShell often enough for work, I'm used to deal with it. Once I've got it working in PS on a level I'm satisfied with, I may port it to other environments, most likely Javascript (I may need some help with that...).

## Then what's with the Java files?

[Sebstone](https://github.com/sebstone) had the original Idea for this project. When he told me about him working in Java on it, I thought I could try to write it in PowerShell myself as a fun side-project. After I worked on it a little bit, I've invited him to also host his Java project on my repo so we could work of eachothers ideas and code. And maybe even host/distribute functional versions. Once they exist. Eventually...
