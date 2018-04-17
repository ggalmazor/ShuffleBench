const shuffle = require('fisher-yates');
const PRNG = require('tiny-prng');
const fs = require('fs');

const generator = new PRNG(42.0);

const lemario = fs.readFileSync('../resources/data/lemario.txt', 'utf8').split("\n");

shuffle(lemario, function() { return generator.nextFloat(); })
    .slice(0, 10)
    .forEach(line => console.log(line));
