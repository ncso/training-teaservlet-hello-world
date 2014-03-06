#!/bin/sh
set -eu
MVN_CLI_FLAGS=${MVN_CLI_FLAGS:---offline clean package}; export MVN_CLI_FLAGS
exec ./compile.sh
