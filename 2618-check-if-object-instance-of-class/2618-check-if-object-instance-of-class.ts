function checkIfInstanceOf(obj: any, classFunction: any): boolean {
    if(obj === null || obj === undefined || typeof classFunction  !== "function"){
        return false;
    }
    
    let currProtentialPrototype = Object.getPrototypeOf(obj);
    
    while(currProtentialPrototype !== null){
        if(currProtentialPrototype === classFunction.prototype){
            return true;
        }
        currProtentialPrototype = Object.getPrototypeOf(currProtentialPrototype);
    }
    
    return false;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */