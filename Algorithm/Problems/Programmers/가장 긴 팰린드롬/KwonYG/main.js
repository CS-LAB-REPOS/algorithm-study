function isPalin(str) {
    let leftIndex = 0;
    let rightIndex = str.length - 1;

    while (leftIndex < rightIndex) {
        if (str[leftIndex] != str[rightIndex]) {
            return false;
        }
        leftIndex++;
        rightIndex--;
    }
    return true;
}

function solution(s) {
    let strLength = s.length;

    if (strLength == 0 || strLength == 1) {
        return strLength == 0 ? 0 : 1;
    }

    for (let i = strLength; i > 2; i--) {
        for (let j = 0; j <= strLength - i; j++) {
            let selected = s.substring(j, j + i);

            if (isPalin(selected)) {
                return selected.length;
            }
        }
    }
    return 2;
}