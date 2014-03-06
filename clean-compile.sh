#!/bin/sh
set -eu
MVN_CLI_FLAGS=${MVN_CLI_FLAGS:---offline clean compile}; export MVN_CLI_FLAGS
exec ./compile.sh
