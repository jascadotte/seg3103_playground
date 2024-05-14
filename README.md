# seg3103_playground

## Steps

### Git:

#### Install
`sudo apt update`
`sudo apt install git`
`git --version`

#### Configure
`git config --global user.name "jascadotte"`
`git config --global user.email "---@gmail.com"`
`git config --list`

#### Clone Repository
`git clone https://github.com/jascadotte/seg3103_playground.git`
`cd seg3103_playground/`
`git status`
`mkdir assets`
`git add assets`
`git status`
`git remote set-url origin https://ghp_T---YaF@github.com/jascadotte/seg3103_playground`
`git status`

#### Push to main
`git add .`
`git status`
`git commit -m "update repository"`
`git push origin main`

### Java:

#### Install
`sudo apt install default-jdk`
`javac -version`
`sudo apt install junit5`

#### Run & Test
`cd newmath_java/`
`cd bin`
`nano run`
`nano test`
`cd ..`
`./bin/run`
`./bin/test`

### Elixir:

#### Install
`sudo apt install erlang-dev elixir`

#### Run & Test
`cd newmath_ex`
`./bin/run`
`./bin/test`

### Python:

#### Check status
`python --version`

#### Run & Test
`cd newmath_py`
`./bin/run`
`./bin/test`
