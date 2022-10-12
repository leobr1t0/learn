const valores = [];
var qtd = 0
setInterval(function geraValores() {
    const valoresRandom = parseInt(Math.random(0,1).toFixed());
    valores.push(valoresRandom);
    const fluxo = valores.filter(function(count){
        if(count == 1) {
            qtd++;   
            return count;
        }
    })
    console.log(`${qtd} pessoas no setor`);
}, 1000)
