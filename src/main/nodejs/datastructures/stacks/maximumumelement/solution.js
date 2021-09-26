'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function (inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function () {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}

/*
 * Complete the 'getMax' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts STRING_ARRAY operations as parameter.
 */

function getMax(operations) {
    let max = [];
    let stack = [];
    let result = [];
    for (let i = 0; i < operations.length; i++) {
        let op = operations[i];
        let arr = op.split(" ");
        let operation = Number(arr[0]);
        switch (operation) {
            case 1 :
                push(Number(arr[1]), stack, max);
                break;
            case 2 :
                del(stack, max);
                break;
            case 3 :
                if (max.length != 0) {
                    let m = max[max.length - 1];
                    console.log("Printing max element")
                    result.push(m);
                }
                break;
        }
    }
    return result;
}

function push(item, stack, max) {
    console.log("Pushing " + item);
    stack.push(item);
    if (max.length != 0) {
        let n = max[max.length - 1];
        if (item >= n) {
            console.log("Max updated " + item);
            max.push(item);

        } else {
            console.log("Max updated " + item);
            max.push(n);
        }
    } else {
        max.push(item);
    }
}

function del(stack, max) {
    if (stack.length > 0) {
        let n = stack.pop();
        console.log("Deleting " + n);
    }
    if (max.length > 0) {
        let m = max.pop();
        console.log("Deleting " + m);
    }
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const n = parseInt(readLine().trim(), 10);

    let ops = [];

    for (let i = 0; i < n; i++) {
        const opsItem = readLine();
        ops.push(opsItem);
    }

    const res = getMax(ops);

    ws.write(res.join('\n') + '\n');

    ws.end();
}
