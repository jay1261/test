SELECT ANIMAL_ID, NAME, 
    if(SEX_UPON_INTAKE like "Neutered%" OR SEX_UPON_INTAKE like "Spayed %", "O", "X") as "중성화"
from ANIMAL_INS