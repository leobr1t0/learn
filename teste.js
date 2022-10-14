const valores = [];
const maxSetor = 15;
const minSetor = 5;
var qtd = 0;
setInterval(function geraValores() {

    const valoresRandom = parseInt(Math.random(0, 1).toFixed());
    valores.push(valoresRandom);

    const fluxo = valores.filter(function (count) {
        if (count == 1) {
            return count;
        }
    });
    qtd = fluxo.length;

    if(qtd < minSetor) {
        console.log('Pouco fluxo')
    } else if(qtd < maxSetor) {
        console.log(`${qtd} pessoas no setor`);
    } else if(qtd == maxSetor) {
        console.log('Superlotação!')
    }
    // console.log(`${fluxo} pessoas no setor`)
}, 1000);


