import sys
from PIL import Image
from pytesseract import pytesseract
#baselinelocation = sys.argv[1]

def retriveTextFromImage(image_path,textfilepath):

    #print(baselinelocation)
    #currentreleasefile = sys.argv[2]
    path_to_tesseract = r"C:\Program Files\Tesseract-OCR\tesseract.exe"
   # image_path = r"C:\GIT\Balance-Sheet-Examples-2.jpg"
    # Opening the image & storing it in an image object
    img = Image.open(image_path)
    pytesseract.tesseract_cmd = path_to_tesseract
    text = pytesseract.image_to_string(img)
    #print(text)
    file = open(textfilepath,'w')
    file.write(text)
    file.close()

    #print(baselinelocation)

def main():
    impagPth = sys.argv[1]
    textPath = sys.argv[2]
    print(impagPth)
    print(textPath)
    #retriveTextFromImage(r"C:\GIT\Balance-Sheet-Examples-2.jpg",'c:\GIT\File.txt')
    retriveTextFromImage(impagPth, textPath)
    #modified_data = process_data(data)
    #print(modified_data)

if __name__ == "__main__":
    main()
