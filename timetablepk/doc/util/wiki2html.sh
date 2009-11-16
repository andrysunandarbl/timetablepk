script='./google-wiki-syntax/wiki_convertor.rb'
include='-I ./google-wiki-syntax'
src='../../../../wiki'
dest='../html'
ruby $include $script $src $dest
